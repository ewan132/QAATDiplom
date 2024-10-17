FROM node:18-alpine
WORKDIR /gate-simulator/app
COPY package.json .
RUN npm start
COPY . .
EXPOSE 9999
CMD ["node", "app.js"]