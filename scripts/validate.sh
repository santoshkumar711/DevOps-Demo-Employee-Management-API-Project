
#!/bin/bash
set -e

HEALTH_URL="http://localhost:8084/actuator/health-test"

echo "Waiting for Employee API to become healthy..."

for i in {1..24}; do
    if curl --fail --silent "$HEALTH_URL" | grep -q '"status":"UP"'; then
        echo "Employee API health check passed."
        exit 0
    fi

    echo "Health check attempt $i failed. Retrying..."
    sleep 5
done

echo "ERROR: Employee API did not become healthy."
exit 1
