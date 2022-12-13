# better-life
Better life is an Android application which allows people to donate and receive donations around the world , In our application the user can ask for a donation and he can donate also in the same time, the user will give his name , description  of the item and phone number ,this way is valid for either donation or request. After that the application will take user location and  mark in his location which includes the name ,type(donor , receiver ) ,phone number and description.
-for Donor ![image](https://user-images.githubusercontent.com/96696339/207243154-83167d9f-4b89-4fc4-b3e1-e45b675f639e.png)
-for receiver ![image](https://user-images.githubusercontent.com/96696339/207243221-4ae2fa99-f022-4612-8b21-f08fc60511bf.png)
So other users are able to see the donations and donation requests in the map. So users can contact with each other by provided phone number.

![image](https://user-images.githubusercontent.com/96696339/207244337-342d6aee-1cf9-4e19-ad0d-bbda19c4eafd.png)

Used technology:
 -Android studio
 -Java programing language
 -XML
 -Firebase: 
     .Authentication(sign in method)
     .Firestore database(NoSQL database)

![image](https://user-images.githubusercontent.com/96696339/207243445-4b40407e-2b5c-4d11-aa7d-b0fb62ad2d81.png)


We have four collections, each collection has documents , each documents has fields.
1-Contact data : this collection has data which entered from user when he askes to contact with us , it has email , message, name , time and userid.
2-Donation details: it has a data of any post from user either donation or asking for donation, it contains description , Donation Item , Location, name , phone number ,   time , type , userid
3-Users: it contains user registrations details email , name ,password and phone number
4-Admin: It contains admin details DOB , Email, Phone number , name , password

# video explains how does it work:
https://www.youtube.com/shorts/gV1zybCICW8


