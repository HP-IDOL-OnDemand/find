<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:eval expression="@dispatcherProperties['application.version']" var="applicationVersion"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Find</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" type="image/ico" href="../static-${applicationVersion}/favicon.ico">
        <!--[if IE 7]>
        <link rel="stylesheet" type="text/css" href="../static-${applicationVersion}/lib/fontawesome/css/font-awesome-ie7.css"/>
        <![endif]-->
        <link rel="stylesheet" type="text/css" href="../static-${applicationVersion}/css/app.css"/>

        <!--[if IE]>
        <script type="text/javascript" src="../static-${applicationVersion}/lib/excanvas/excanvas.js"></script><![endif]-->
        <script type="text/javascript" src="../static-${applicationVersion}/lib/require/require.js" data-main="../static-${applicationVersion}/js/main.js"></script>
    </head>
    <body>
        <div class="page">
            <div class="initial-loading-indicator-container">
                <div class="initial-loading-indicator">
                    <i class="icon-spinner icon-spin"></i> Loading Find...
                </div>
            </div>
        </div>
    </body>
</html>