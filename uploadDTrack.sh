#!/bin/sh
echo $VERSION
echo $DTRACK_TOKEN
echo $PROJECT_NAME
curl -X "POST" "https://dtrack-api.formular-demo.de/api/v1/bom" -H 'Content-Type: multipart/form-data' -H "X-Api-Key: $DTRACK_TOKEN" -F 'autoCreate=true' -F "projectName=$PROJECT_NAME" -F "projectVersion=$VERSION" -F 'isLatest=true' -F 'parentName=OpenPDF' -F "bom=@result.json"