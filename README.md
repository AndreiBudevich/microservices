## Java Enterprise

-------------------------------------------------------------
- Stack: [JDK 17](http://jdk.java.net/17/), Spring Boot 3.0.1, Docker, Docker Compose,  Lombok, PostgreSQL, MongoDB
-----------------------------------------------------

### Credenshels:

Admin: admin@admin.by / admin

User:  user@gmail.com / password

-----------------------------------------------------

### Authenticate as an admin and get a token

curl --location --request POST 'http://localhost:8080/token' \
--header 'Authorization: Basic YWRtaW5AYWRtaW4uYnk6YWRtaW4='

### Create user

curl --location --request POST 'http://localhost:8080/api/admin/users' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5ieSIsImlkIjoyLCJleHAiOjE2NzQyMTg0NTgsImlhdCI6MTY3NDIxNDg1OCwicm9sZXMiOiJVU0VSIEFETUlOIn0.BOlDVMEpOHJIK3BWbSdWpV-Qx8g-lJWejs5qxPQ830ME9rwTjWhSui9yXoljS26xm1EdohQu55QWDHwLaiDRMvtNpwrX8r8vjwUkGwr6ql0lB4ktANxPiaLswC7ePpFSTS0hOwlv-pFEqFmxDYymAprWBmj0QvzMIiljyHbwhiV-mVWUbqkcafign3IvLmXlyn_E5sYRoWLn6sbeZ2tUcYoFjVvyAWgTXdltVNMPAHhTouvqApq_h7_QmqlUbtWslEe8_SeyNxGSbFaAvhg58rZdD1n1TahTD60BFtYcv93MQ4FHMu5gmjIJW9uJ8jMqwczG19ZsgdCRty5kdnNpwQ' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "user1",
"email": "user1@gmail.com",
"password": "user1"
}'

### Create application

curl --location --request POST 'http://localhost:8090/api/users/application' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5ieSIsImlkIjoyLCJleHAiOjE2NzQyMTc4MTYsImlhdCI6MTY3NDIxNDIxNiwicm9sZXMiOiJVU0VSIEFETUlOIn0.WLR_jxdxmHwRL4V-2kwxZxWhYatRd0Bw3bVLsb-1JSBpGYOkDEiG4kCSi4VQ8tyhN_2FZillmhEU5OPGKtNDTLAyZ69xVuSamgDN7SVVMpw_nBy_6kb6q5RqEXxBjQ8WRCg7yhwj0sma7nXzz7ZzSsPQetxa0d9cKqUcmLmRpZjGMdIKhTRAKTb1nAxqf6DqxlhLm_wxl_gSOmwWDvgYfPoEiBemRtXHiWXRWi2BS9xQsKklorYwabQ0gLGik-P1P0uJi0qjmfBXmI8LLKZrnzCg-0Tpmo01NN68h5ueMyijAPI9Y_KASep3iq8l7j_y1HVCPAt-X9E1ktbScDJRZQ' \
--header 'Content-Type: application/json' \
--data-raw '{
  "hashes": [
    "c4ca4238a0b923820dcc509a6f75849b",
    "c81e728d9d4c2f636f067f89cc14862c",
    "eccbc87e4b5ce2fe28308fd9f2a7baf3"
  ]
}'

### Decryption of hashes
curl --location --request GET 'http://localhost:8090/api/users/application/1/hash' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5ieSIsImlkIjoyLCJleHAiOjE2NzQyMDI4NjMsImlhdCI6MTY3NDE5OTI2Mywicm9sZXMiOiJVU0VSIEFETUlOIn0.nfcXBm2V3E_xhVi3WBbPbqqJGPdTnhT-B1eWIa9Rb8e1VVKc6fESIxdD4QR3bYbM3vbybdey3qv5tNN1RcPaUg8KS6fYWRyd7CKHccW5t8nN1kjZodr_hu4LgsHozcqrLrhnCsGfBluR23mCRnSWVHeiZrRRGRQhjIwSc8c9BaTV2kx4Axhh7ATWUxtmurBCoacZG_41Kdk5LOqiH8zCkA3wU3i2BubqKcZQ4vFnuBnh_lSxeyi27PZBjaqD1mx5aTNZ9rVR2R81-Rb_kv5oTsZwAOOafsQqK3zeddkR_T4ftF6YYQRyeKJj3sd1F6ItNBFfdPZRGfhitjjopnXCgQ'