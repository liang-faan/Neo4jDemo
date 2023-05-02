## simple test API
### install neo4j docker in local
```shell
# start up neo4j docker command
docker run -d --publish=7474:7474 --publish=7687:7687 --volume=neo4j-data:/data --env NEO4J_dbms_security_procedures_allowlist=* neo4j:5.6.0-community
```
### retrieve jwt token
```shell
export TOKEN=`curl -XPOST tester:password@localhost:8080/token`
```

```shell
# Test API with TOKEN
curl -H "Authorization: Bearer $TOKEN" localhost:8080 && echo
```