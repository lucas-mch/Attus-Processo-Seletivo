#!/bin/sh
docker run --name postgresql -e POSTGRES_PASSWORD=123 -d -p 5433:5432 postgres:16