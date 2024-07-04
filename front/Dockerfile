FROM node:latest as build

WORKDIR /usr/local/app
COPY ./ /usr/local/app/

RUN yarn
RUN npm run build
 
FROM nginx:latest as production

COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/local/app/dist/bobapp /usr/share/nginx/html

EXPOSE 80