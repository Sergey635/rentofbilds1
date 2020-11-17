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
        <legend>Add client</legend>
        <form name="client" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Gender:<@spring.formSingleSelect "form.gender", genders, ""/>
            <br>
            Adres:<@spring.formInput "form.adres" "" "text"/>
            <br>
            Phone:<@spring.formInput "form.phone" "" "text"/>
            <br>
            Birthday:<@spring.formInput "form.birthday" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>