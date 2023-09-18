## simple test API
### install neo4j docker in local
```shell
# start up neo4j docker command
# docker run -d --publish=7474:7474 --publish=7687:7687 --volume=neo4j-data:/data --env NEO4J_dbms_security_procedures_allowlist=* neo4j:5.6.0-community
docker run -d --publish=7474:7474 --publish=7687:7687 --volume=neo4j-data:/data --volume=neo4j-plugins:/var/lib/neo4j/plugins --volume=neo4j-logs:/logs --name=neo4j-v5.9.0 --env NEO4J_dbms_security_procedures_allowlist=* neo4j:5.9.0-community
```
### retrieve jwt token
```shell
export TOKEN=`curl -XPOST tester:password@localhost:8080/token`
```

```shell
# Test API with TOKEN
curl -H "Authorization: Bearer $TOKEN" localhost:8080 && echo
```

## Test Journey creation
```shell
curl -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' -X POST 'http://localhost:8080/jobs/create' -d '{
    "status": "A",
    "journeys": [
      {
        "status": "A",
        "journeyId": "CBG-1A",
        "journeyName": "Test CBG",
        "journeyDescription": "This is first journey",
        "appGroupNodes": [
          {
            "index": 0,
            "appGroupName": "Frontend",
            "status": "A",
            "appInstances": [
              {
                "status": "A",
                "appCode": "APIGW",
                "appName": "API Gateway",
                "application": {
                  "status": "A",
                  "appCode": "API_GW",
                  "appName": "API Gateway",
                  "lob": "FE"
                }
              }
            ]
          },
          {
            "index": 1,
            "appGroupName": "Backend",
            "status": "A",
            "appInstances": [
              {
                "status": "A",
                "appCode": "OFT",
                "appName": "OFT Gateway",
                "application": {
                  "status": "A",
                  "appCode": "OFT",
                  "appName": "OFT Gateway",
                  "lob": "BE"
                }
              }
            ]
          }
        ]
      }
    ]
  }'


```

## Another complex model
```shell
curl -H "Authorization: Bearer $TOKEN" -H 'Content-Type: application/json' -X POST 'http://localhost:8080/jobs/create' -d '{
    "status": "A",
    "version": 0,
    "jobName": "Scan & Pay",
    "jobDescription": "I want to pay at restaurants. ",
    "journeys": [
        {
            "status": "A",
            "version": 0,
            "journeyId": "CBG-2A",
            "journeyName": "Test CBG22222",
            "journeyDescription": "This is first journey",
            "appGroupNodes": [
                {
                    "status": "A",
                    "version": 0,
                    "index": 0,
                    "appGroupName": "Frontend22",
                    "appInstances": [
                        {
                            "status": "A",
                            "version": 0,
                            "appCode": "APIGW22",
                            "appName": "API Gateway22",
                            "application": {
                                "status": "A",
                                "version": 0,
                                "appCode": "API_GW22",
                                "appName": "API Gateway",
                                "lob": "FE"
                            }
                        }
                    ],
                    "nextAppGroups": [
                        {
                            "nextAppGroup": {
                                "status": "A",
                                "version": 0,
                                "index": 1,
                                "appGroupName": "Backend22",
                                "appInstances": [
                                    {
                                        "status": "A",
                                        "version": 0,
                                        "appCode": "OFT22",
                                        "appName": "OFT Gateway",
                                        "application": {
                                            "status": "A",
                                            "version": 0,
                                            "appCode": "OFT22",
                                            "appName": "OFT22 Gateway",
                                            "lob": "BE22"
                                        }
                                    }
                                ],
                                "nextAppGroups": [
                                    {
                                        "nextAppGroup": {
                                            "status": "A",
                                            "version": 0,
                                            "index": 0,
                                            "appGroupName": "Frontend22"
                                        }
                                    }
                                ]
                            }
                        }
                    ]
                },
                {
                    "status": "A",
                    "version": 0,
                    "index": 1,
                    "appGroupName": "Backend22",
                    "appInstances": [
                        {
                            "status": "A",
                            "version": 0,
                            "appCode": "OFT22",
                            "appName": "OFT Gateway",
                            "application": {
                                "status": "A",
                                "version": 0,
                                "appCode": "OFT22",
                                "appName": "OFT22 Gateway",
                                "lob": "BE22"
                            }
                        }
                    ],
                    "nextAppGroups": []
                },
                {
                    "status": "A",
                    "version": 0,
                    "index": 2,
                    "appGroupName": "Backend33",
                    "appInstances": [
                        {
                            "status": "A",
                            "version": 0,
                            "appCode": "OFT22",
                            "appName": "OFT Gateway",
                            "application": {
                                "status": "A",
                                "version": 0,
                                "appCode": "OFT22",
                                "appName": "OFT22 Gateway",
                                "lob": "BE22"
                            }
                        }
                    ]
                }
            ]
        }
    ]
}'
```