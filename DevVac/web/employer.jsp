<%@ page import="java.util.Vector" %>
<%@ page import="mapping.Employer" %>


<%
    Vector<Employer> emp= (Vector<Employer>) request.getAttribute("employer");
%>

<div class="card">
    <div class="card-body">
        <h4 class="card-title">Tous les employer</h4>
        </p>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Id Employer</th>
                    <th>Nom</th>
                    <th>Age</th>
                    <th>Modifier</th>
                    <th>Suprimer</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (int i = 0; i <emp.size() ; i++) {

                %>
                <tr>
                    <td><%=emp.get(i).getIdEmployer()%></td>
                    <td><%=emp.get(i).getNom()%></td>
                    <td><%=emp.get(i).getAge()%></td>
                    <td> <a href="insererEmployer?action=update&id=<%=emp.get(i).getIdEmployer() %>"><button type="button" class="btn btn-inverse-warning btn-fw">Modifier</button></a></td>
                    <td><a href="insererEmployer?action=del&id=<%=emp.get(i).getIdEmployer() %>"><button type="button" class="btn btn-inverse-danger btn-fw">Suprimer</button></a></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>