This is a [Next.js](https://nextjs.org/) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Getting Started

First, run the development server:

```bash
npm run dev
# or
yarn dev
# or
pnpm dev
# or
bun dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

You can start editing the page by modifying `pages/index.js`. The page auto-updates as you edit the file.

[API routes](https://nextjs.org/docs/api-routes/introduction) can be accessed on [http://localhost:3000/api/hello](http://localhost:3000/api/hello). This endpoint can be edited in `pages/api/hello.js`.

The `pages/api` directory is mapped to `/api/*`. Files in this directory are treated as [API routes](https://nextjs.org/docs/api-routes/introduction) instead of React pages.

This project uses [`next/font`](https://nextjs.org/docs/basic-features/font-optimization) to automatically optimize and load Inter, a custom Google Font.

## Learn More

To learn more about Next.js, take a look at the following resources:

- [Next.js Documentation](https://nextjs.org/docs) - learn about Next.js features and API.
- [Learn Next.js](https://nextjs.org/learn) - an interactive Next.js tutorial.

You can check out [the Next.js GitHub repository](https://github.com/vercel/next.js/) - your feedback and contributions are welcome!

## Deploy on Vercel

The easiest way to deploy your Next.js app is to use the [Vercel Platform](https://vercel.com/new?utm_medium=default-template&filter=next.js&utm_source=create-next-app&utm_campaign=create-next-app-readme) from the creators of Next.js.

Check out our [Next.js deployment documentation](https://nextjs.org/docs/deployment) for more details.


IMPORTANTE:

Luego de eliminar estas carpetas, puedes volver a instalar las dependencias ejecutando npm install para recrear la carpeta node_modules. Para el caso de Next.js, al ejecutar npm run dev o el script que uses para iniciar tu aplicación, la carpeta .next se regenerará con los archivos necesarios durante el proceso de construcción.

Eliminar:

    - Remove-Item -Path ".next" -Recurse -Force
    - Remove-Item -Path "node_modules" -Recurse -Force

Despues ejecutar:

    - npm install
    - npm run dev


COSAS UTILES: https://trekinbami.medium.com/using-environment-variables-in-react-6b0a99d83cf5

useContext: https://www.youtube.com/watch?v=2-6K-TMA-nw

Instalarme esto para variables globales (.env): npm install dotenv
Instalar axios: npm install axios


Para ejecutar solo archivos .js debo poner "node script.js" y tener node instalado

Descargarme esto para ver fallos de javascript: ESLint en extensiones

Bibliotecas instaladas: 
    - npm install @mui/material @emotion/react @emotion/styled
    - npm install @mui/icons-material
    - npm install @mui/icons-material @mui/material @emotion/styled @emotion/react
    - npm install @mui/x-data-grid