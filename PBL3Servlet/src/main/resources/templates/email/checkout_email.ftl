<!DOCTYPE html>
<html lang="vi" xmlns="http://www.w3.org/1999/xhtml" xmlns:o="urn:schemas-microsoft-com:office:office" xml:lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Template Email</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    </head>
    <style>
        table,
        td,
        th,
        h2,
        h3,
        h4,
        a,
        p {
            font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,Oxygen-Sans,Ubuntu,Cantarell,"Helvetica Neue",sans-serif;
        }
        @media (max-width: 768px) {
            table {
                width: 100% !important;
            }
            a {
                font-size: 90% !important;
            }
        }
    </style>
    <body style="background-color: #f8f8f9; margin: 0;">
        <table border="0" cellpadding="25" cellspacing="0" align="center" style="background-color: #ffffff; width: 50%;">
            <!-- hình ảnh -->
            <tr>
                <td align="center">
                    <img src="https://res.cloudinary.com/dgext7ewd/image/upload/v1621177588/email_template_PBL3/xemay_iyulve.jpg" alt="S-team" width="200" height="200" border="0" style="display: block;" />
                </td>
            </tr>
            <!-- hello content -->
            <tr>
                <td align="center">
                    <h1>Xin chào Vy ,</h1>
                    <h2>Xe của bạn đã checkout khỏi bãi !</h2>
                    <p>Xem thông tin chi tiết ở bảng dưới</p>
                </td>
            </tr>
            <!-- table -->
            <tr>
                <td>
                    <table
                        border="0"
                        align="center"
                        cellpadding="8"
                        cellspacing="0"
                        width="90%"
                        style="background: rgb(35, 144, 136); background: linear-gradient(90deg, rgba(35, 144, 136, 1) 4%, rgba(49, 180, 170, 1) 59%, rgba(33, 212, 212, 1) 89%); border-radius: 15px !important; color: white; padding: 2%;"
                    >
                        <tbody>
                            <tr align="center">
                                <th colspan="2">Thông tin chi tiết</th>
                            </tr>
                            <tr align="center">
                                <th width="50%">Biển số xe</th>
                                <td width="50%">${ plate_number }</td>
                            </tr>
                            <tr align="center">
                                <th>Giờ gửi xe</th>
                                <td>${ checkin_at }</td>
                            </tr>
                            <tr align="center">
                                <th>Giờ lấy xe</th>
                                <td>${ checkout_at }</td>
                            </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
            <tr>
                <td align="center" style="padding-bottom: 10%;">
                    <a border="0" href="#" style="text-decoration: none; color: #ffffff; background-color: #59c4c0; text-align: center; word-break: keep-all; font-size: 110%; padding: 3% 10%; font-weight: 500; border-radius: 50em;">
                        <span>Xem chi tiết trong website</span>
                    </a>
                </td>
            </tr>
        </table>
        <table border="0" cellpadding="25" cellspacing="0" align="center" style="background-color: #2b303a; width: 50%; margin-top: 5%; color: #ffffff;">
            <!-- hình ảnh -->
            <tr>
                <td align="center">
                    <a>
                        <img src="https://sgroupvn.org/_nuxt/img/sgr_logo-symbol.0ce37a9.png" width="150" height="150" alt="S-PBL" />
                    </a>
                </td>
            </tr>
            <tr>
                <td>
                    <table border="0" align="center" cellpadding="8" cellspacing="0" width="75%" style="border-radius: 15px !important; color: white; padding: 2%;">
                        <tbody>
                            <tr align="center">
                                <th><img width="60px" src="https://res.cloudinary.com/dgext7ewd/image/upload/v1621177588/email_template_PBL3/facebook2x_lopu1j.png" alt="" srcset="" style="margin: 0 5%;" /> <img width="60px" style="margin: 0 5%;" src="https://res.cloudinary.com/dgext7ewd/image/upload/v1621177588/email_template_PBL3/mail2x_h7zwl9.png" alt="" srcset="" /></th>
                            </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
            <!-- hello content -->
            <tr>
                <td align="center">
                    <p>Cảm ơn bạn đã sử dụng hệ thống gửi xe của chúng tôi !</p>
                    <p>
                        Chúng tôi sẽ thông báo cho bạn khi xe của bạn checkout lần tới !
                    </p>
                </td>
            </tr>
            <!-- Thông tin -->
            <tr>
                <td align="center"><small>S-team Copyright © 2021</small></td>
            </tr>
        </table>
    </body>
</html>
