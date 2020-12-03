<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<h3>Records List</h3>
<body>
<button onclick="window.location.href = '/web/record/all'">Renew</button>
<br>

<#--<fieldset>
    <form name="client" action="" method="POST">
        Search:<@spring.formInput "search.name" "" "text"/>
        <br>
        <input type="submit" value="Find"/>
    </form>
</fieldset>
<br>-->
<a href="/index.html">Back</a>
<div>

    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Start</th>
            <th>Finish</th>
            <th>Client</th>
            <th>Build</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list records as element>
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.start}</td>
                <td>${element.finish}</td>
                <td>${element.client.name}</td>
                <td>${element.build.name}</td>
                <#--<td>${element.created_at}</td>
                <td>${element.modified_at}</td>-->
                <td><a href="/web/record/delete/${element.id}" class="btn btn-warning">Delete</a></td>
                <td><a href="/web/record/update/${element.id}" class="btn btn-outline-danger">Edit</a></td>

            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/web/record/create">Create</a>

</div>
</body>
</html>