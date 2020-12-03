<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>


<h3 style="text-align: center">Item List</h3>
<fieldset>
    <form name="client" action="" method="POST">
        Search:<@spring.formInput "search.name" "" "text"/>
        <input type="submit" value="Search"/>
    </form>
</fieldset>
<br>
<a href="/web/item/all" class="badge badge-danger">Refresh</a>
<br>
<a href="/index.html" class="badge badge-info">Back</a>
<div>

    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th>Name <button class="btn btn-dark" onclick="window.location.href =
            '/web/item/all/sort'">
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-down-up" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M11.5 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L11 2.707V14.5a.5.5 0 0 0 .5.5zm-7-14a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L4 13.293V1.5a.5.5 0 0 1 .5-.5z"/>
                </svg></button></th>

            <th>Description</th>
            <th>Created</th>
            <th>Modified</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list items as element> <!--Цикл по всем element !! -->
        <!--Для каждого element в списке items , который мы получили
         из контроллера . -----------------------------
         Формируем строку <tr>. У этой строки есть ..5.. ячеек
          Каждая ичейка является полем ..елемента.. !
          (id)(name) т.д !!! -->
        <tr>
            <td>${element.id}</td>
            <td>${element.name}</td>
            <td>${element.description}</td>
            <td>${element.created_at}</td>
            <td>${element.modified_at}</td>
            <td><a href="/web/item/delete/${element.id}" class="btn btn-warning">Delete</a></td>
            <td><a href="/web/item/update/${element.id}" class="btn btn-outline-danger">Edit</a></td>

        </tr>
        </#list>
        </tbody>
    </table>
    <a href="/web/item/create">Create</a>
</div>

</body>
</html>