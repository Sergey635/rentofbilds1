<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<div>
<fieldset>
    <legend>Update item</legend>
    <form name="item" action="" method="POST">
        Name:<@spring.formInput "form.name" "" "text"/>
        <br>
        Description:<@spring.formInput "form.description" "" "text"/>
        <br>
        <input type="submit" value="Update"/>
    </form>
</fieldset>
</div>
</body>
</html>