> docker stack deploy --compose-file=./docker-compose.yml pg-stack

> docker service ls

> docker service ps pg-stack_primary

> docker service ps pg-stack_replica

> docker service scale pg-stack_replica=2

> docker service ps pg-stack_replica

> docker build -t docker.io/rjdhumberto/session_controller:0.0.1 .

```bash
docker service create \
   --name "javabackendservice" \
   --replicas 2 \
   --network pg-stack_crunchynet  \
   --reserve-memory 200MB \
   --env "TZ=America/Mexico_City" \
   --publish published=7777,target=7777 \
   docker.io/rjdhumberto/session_controller:0.0.2