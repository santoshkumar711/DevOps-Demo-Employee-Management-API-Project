
#!/bin/bash
set -e

if systemctl is-active --quiet santosh-api; then
    systemctl stop santosh-api
    echo "Existing Employee API service stopped."
else
    echo "Employee API service is not running."
fi

exit 0
