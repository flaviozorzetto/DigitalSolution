## Integrantes

- Flavio Esrenko Zorzetto RM93175
- Lucas Kenji Nishida RM94233
- Wesley Novais Kleim RM94412
- Jorge Rodrigo dos Santos RM93418
- Lucas Gonçalves Leu De Lima RM88349

## Instruções de como rodar

Construir a imagem utilizando:

```console
docker build -t vlearn-app .
```

E rodar utilizando:

```console
docker run -p 8080:8080 vlearn-app
```

## Informações sobre o deploy

Este repositorio está utilizando Github Actions como provedor de CI/CD para fazer o deploy no azure web apps ao fazer o git push, mas qualquer nuvem poderia aceitar a imagem do dockerfile como referencia de build do projeto
