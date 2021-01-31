# PokeApiAleaDemo

This application was generated using JHipster 6.10.5, you can find documentation and help at [https://www.jhipster.tech/documentation-archive/v6.10.5](https://www.jhipster.tech/documentation-archive/v6.10.5).

## Development

To start your application in the dev profile, run:

```
./mvnw
```

The application exposes 3 endpoints which can be accessed at http://localhost:8080/:

```
/height
/weight
/base-xp
```

The endpoints return the top 5 pokemons for each category only from the "red version", which are the first 151 pokemons.

The application runs a feign client at the start up which accesses a public endpoint, retrieves the pokemons and stores
the locally to be used for further processing.

!<b>IMPORTANT!
If the application only returns the first 10 pokemons, it meanse I forgot to decomment the TODO :(
## Testing

To launch your application's tests, run:

```
./mvnw verify
```

For more information, refer to the [Running tests page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a postgresql database in a docker container, run:

```
docker-compose -f src/main/docker/postgresql.yml up -d
```

To stop it and remove the container, run:

```
docker-compose -f src/main/docker/postgresql.yml down
```

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

```
./mvnw -Pprod verify jib:dockerBuild
```

Then run:

```
docker-compose -f src/main/docker/app.yml up -d
```

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.
