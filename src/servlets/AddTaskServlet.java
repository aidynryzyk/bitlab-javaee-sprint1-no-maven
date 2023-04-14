package servlets;

import db.DBManager;
import db.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        if (!req.getParameter("name").isEmpty() && !req.getParameter("date").isEmpty()) {
            Task task;
            if (req.getParameter("id") == null) {
                task = new Task(
                        req.getParameter("name"),
                        req.getParameter("desc"),
                        req.getParameter("date"),
                        false
                );
            } else {
                task = new Task(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("desc"),
                        req.getParameter("date"),
                        !req.getParameter("status").equals("0")
                );
            }
            dbManager.addTask(task);
        }
        req.setAttribute("tasks", dbManager.getAllTasks());
        req.getRequestDispatcher("tasks.jsp").forward(req, resp);
    }
}
