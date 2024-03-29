<%@ page import="java.util.Vector" %>
<%@ page import="mapping.Table" %>


<%
    Vector<Table> tab= (Vector<Table>) request.getAttribute("table");
%>

<div class="card">
    <div class="card-body">
        <h4 class="card-title">Tous les Tables</h4>
        </p>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Id Table</th>
                    <th>Nom</th>

                    <th>Modifier</th>
                    <th>Suprimer</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (int i = 0; i <tab.size() ; i++) {

                %>
                <tr>
                    <td><%=tab.get(i).getIdtable()%></td>
                    <td><%=tab.get(i).getNom()%></td>
                    <td> <a href="insererTable?action=update&id=<%=tab.get(i).getIdtable() %>"><button type="button" class="btn btn-inverse-warning btn-fw">Modifier</button></a></td>
                    <td><a href="insererTable?action=del&id=<%=tab.get(i).getIdtable() %>"><button type="button" class="btn btn-inverse-danger btn-fw">Suprimer</button></a></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>