// docker compose
docker compose build
docker compose up
docker compose down

// image stats
docker stats

// image size
docker inspect -f "{{ .Size }}" <image-name> | numfmt --to=si

