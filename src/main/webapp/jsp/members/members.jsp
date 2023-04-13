<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    private MemberRepository MemberRepository = MemberRepository.getInstance();
    List<Member> members = MemberRepository.findAll();
%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

    </body>
</html>