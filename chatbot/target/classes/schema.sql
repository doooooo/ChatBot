--Ref: https://www.javatpoint.com/spring-boot-h2-database
--Ref: https://razorsql.com/features/h2_add_foreign_key.html

DROP TABLE IF EXISTS MESSAGE;  
CREATE TABLE MESSAGE (  
message_id INT PRIMARY KEY,  
message VARCHAR(50) NOT NULL
);  

DROP TABLE IF EXISTS INTENT_MESSAGE;  
CREATE TABLE INTENT_MESSAGE (  
intent_message_id int PRIMARY KEY,  
message_id int NOT NULL,  
intent_id int NOT NULL,
confidence int NOT NULL
);  

DROP TABLE IF EXISTS INTENT;  
CREATE TABLE INTENT (  
intent_id int PRIMARY KEY,  
reply_id int NOT NULL
);  

DROP TABLE IF EXISTS REPLY;  
CREATE TABLE REPLY (  
reply_id int PRIMARY KEY,  
reply_message VARCHAR(50) NOT NULL
);  

ALTER TABLE INTENT_MESSAGE
ADD FOREIGN KEY (message_id) 
REFERENCES MESSAGE(message_id);

ALTER TABLE INTENT_MESSAGE
ADD FOREIGN KEY (intent_id) 
REFERENCES INTENT(intent_id);

ALTER TABLE INTENT
ADD FOREIGN KEY (reply_id) 
REFERENCES REPLY(reply_id);

