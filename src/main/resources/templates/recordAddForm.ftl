<#--<#import "/spring.ftl" as spring/>-->
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Add record</legend>
        <form name="records" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Start:<@spring.formInput "form.start" "" "text"/>
            <br>
            Finish:<@spring.formInput "form.finish" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>