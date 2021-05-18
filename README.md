# 🍕 PBL3 - HE THONG GUI XE [WEBSITE]

Welcome to our project 😎 \
We're hoping you find anything interesting you in our repository.

## How to deploy app to Heroku
```sh
git clone https://github.com/hovanvydut/PBL3-HeThongGuiXe-Website.git

# copy folder PBL3-HeThongGuiXe-Website/PBL3Servlet to another folder that is not inside this repo

cp -r /PBL3-HeThongGuiXe-Website/PBL3Servlet /home/anotherFolder

cd /home/anotherFolder/PBL3Servlet

# Login heroku
heroku login

# For existing repositories, simply add the heroku remote, 
# [he-thong-gui-xe-v2] is name of heroku app
heroku git:remote -a he-thong-gui-xe-v2

# To build your application simply run:
mvn package

# And then run your app using the java command (please install maven, tomcat before, if not you can ignore this line):
java -jar target/dependency/webapp-runner.jar target/*.war

# if source code has been changed
git init
git add .
git commit -m "Ready to deploy"

# deploy 
git push heroku main
# or
git push heroku main
# or
git push heroku your-branch

```
Now check url: https://he-thong-gui-xe-v2.herokuapp.com
## GLIMPSE THE PROJECT

***
[1]: https://res.cloudinary.com/dgext7ewd/image/upload/v1617588331/unnamed_wpavzb.jpg

- Page A
![Page A][1]

- Page B
![Page B][1]]

- Page C
![Page C][1]

## DEMO ONLINE

***

- 👉 [Admin page](https://www.google.com/)
- 👉 [Client page](https://www.google.com/)

## ⚙️ INSTALLATION

***

Something ...

## 🎉 FEATURES

***

Something ...

## 🪐 Technology

**Web App**: Java Servlet & JSP \
**Desktop App**: Winform \
**Database**: MySQL \
**Tools**: Git, Trello, Slack

## 👨‍🔧 CONTRIBUTORS

***
* Nguyen Huy Tuong - 102190200
* Ho Van Vy - 102190200
* Tran Thi Phuong - 102190200
* Le Hoang Ngoc Han - 102190200

## 🎖 LICENSE

***

## 👀 Where to find us

***

