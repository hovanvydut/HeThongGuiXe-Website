
# 🍕 PBL3 - HE THONG GUI XE [WEBSITE]

🎉 Welcome to our project 😎 \
We're hoping you find anything interesting you in our repository.

## 🐟 See another version of this project at `docker-with-internal-mysql` & `docker_with_azure_db` branch

## How to deploy app to Heroku
```sh
git clone https://github.com/hovanvydut/PBL3-HeThongGuiXe-Website.git

# copy folder PBL3-HeThongGuiXe-Website/PBL3Servlet to another folder that is not inside this repo

cp -r /PBL3-HeThongGuiXe-Website/PBL3Servlet /home/anotherFolder

cd /home/anotherFolder/PBL3Servlet

# To build your application simply run:
mvn package

# And then run your app using the java command (please install maven, tomcat before, if not you can ignore this line):
java -jar target/dependency/webapp-runner.jar target/*.war

# if source code has been changed
git init
git add .
git commit -m "Ready to deploy"

# Login heroku
heroku login

# For existing repositories, simply add the heroku remote, 
# [he-thong-gui-xe-v2] is name of heroku app
heroku git:remote -a he-thong-gui-xe-v2

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

- Home page
![Home page][1]

- Login page
![Login page][2]

- Sign up page
![Sign up page][3]

- Parking History Page
![Parking History Page][4]

- Register Package Page
![Register Package Page][5]

- Reset Password
![Reset Password][6]

- Reset Password
![Reset Password][6]

- Info User
![Info User][7]

And see more details at <ipv4-ec2-aws>


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
[1]:  https://res.cloudinary.com/dgext7ewd/image/upload/v1623249409/PBL-3/README%20github/website/undefined_euhbcy.png
[2]:  https://res.cloudinary.com/dgext7ewd/image/upload/v1623249438/PBL-3/README%20github/website/undefined_dg6cip.png
[3]: https://res.cloudinary.com/dgext7ewd/image/upload/v1623249602/PBL-3/README%20github/website/undefined_uuz0fq.png
[4]: https://res.cloudinary.com/dgext7ewd/image/upload/v1623249994/PBL-3/README%20github/website/screencapture-54-169-120-247-4000-history-2021-06-09-21_46_21_qakbxm.png
[5]: https://res.cloudinary.com/dgext7ewd/image/upload/v1623249773/PBL-3/README%20github/website/screencapture-54-169-120-247-4000-parking-package-list-2021-06-09-21_42_16_d3l6va.png
[6]: https://res.cloudinary.com/dgext7ewd/image/upload/v1623249869/PBL-3/README%20github/website/screencapture-54-169-120-247-4000-customers-reset-password-2021-06-09-21_44_17_ezvejb.png
[7]: https://res.cloudinary.com/dgext7ewd/image/upload/v1623249848/PBL-3/README%20github/website/screencapture-54-169-120-247-4000-customers-info-2021-06-09-21_43_58_aafbo8.png
