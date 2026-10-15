
#!/bin/bash
set -e

APP_DIR="/opt/santosh-api"
JAR_FILE="$APP_DIR/employee.jar"
LOG_FILE="/var/log/santosh-api.log"

mkdir -p "$APP_DIR"
touch "$LOG_FILE"

if [ ! -f "$JAR_FILE" ]; then
    echo "ERROR: JAR file not found: $JAR_FILE"
    exit 1
fi

chown root:root "$JAR_FILE"
chmod 644 "$JAR_FILE"

cat > /etc/systemd/system/santosh-api.service <<'EOF'
[Unit]
Description=Santosh Employee Management API
After=network.target

[Service]
Type=simple
User=root
WorkingDirectory=/opt/santosh-api
EnvironmentFile=-/etc/santosh-api.env
ExecStart=/usr/bin/java -jar /opt/santosh-api/employee.jar
Restart=on-failure
RestartSec=5
StandardOutput=append:/var/log/santosh-api.log
StandardError=append:/var/log/santosh-api.log

[Install]
WantedBy=multi-user.target
EOF

systemctl daemon-reload
systemctl enable santosh-api
systemctl restart santosh-api

sleep 10

if systemctl is-active --quiet santosh-api; then
    echo "Employee API service started successfully."
else
    echo "ERROR: Employee API failed to start."
    systemctl status santosh-api --no-pager || true
    tail -n 50 "$LOG_FILE" || true
    exit 1
fi
