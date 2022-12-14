package controller.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.admin.AdminMainAction;
import controller.admin.AdminMemberAction;
import controller.admin.AdminMemberDeleteAction;
import controller.admin.AdminMemberDetailAction;
import controller.admin.AdminMemberSearchAction;
import controller.admin.AdminMemberUpdateAction;
import controller.admin.AdminNoticeAction;
import controller.admin.AdminNoticeInsertAction;
import controller.admin.AdminRestaurantAction;
import controller.admin.AdminRestaurantDeleteAction;
import controller.admin.AdminRestaurantDetailAction;
import controller.admin.AdminRestaurantSearchAction;

/**
 * Servlet implementation class FrontControllerAd
 */
@WebServlet("*.did")
public class FrontControllerAdmin extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public FrontControllerAdmin() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      try {
         actionDo(request, response);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      try {
         actionDo(request, response);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   private void actionDo(HttpServletRequest request, HttpServletResponse response) throws Exception {

      String uri = request.getRequestURI();
      String cp = request.getContextPath();
      String command = uri.substring(cp.length());
      System.out.println(command);
      ActionForward forward = null;

      // ????????? ???????????????
      if (command.equals("/admin/main.did")) {
         System.out.println("?????? FCAdmin ????????????");
         forward = new AdminMainAction().execute(request, response);
      }

      // ????????? ???????????????
      else if (command.equals("/admin/adminmember.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminMemberAction().execute(request, response);
      }

      // ????????? ?????? ??????
  
      else if (command.equals("/admin/adminmemberupdate.did")) {
         System.out.println("?????? FCAdmin ??????????????????");

         forward=new AdminMemberUpdateAction().execute(request, response);

      }
      // ????????? ?????? ???????????????
      else if (command.equals("/admin/adminmemberdetail.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminMemberDetailAction().execute(request, response);
      }

      // ????????? ????????????
      else if (command.equals("/admin/adminmemberdelete.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminMemberDeleteAction().execute(request, response);
      }

      // ????????? ?????? ??????
      else if (command.equals("/admin/adminmembersearch.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminMemberSearchAction().execute(request, response);
      }

      // ????????? ?????????????????????
      else if (command.equals("/admin/adminnotice.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminNoticeAction().execute(request, response);
      }

      // ????????? ???????????? ??????
      else if (command.equals("/admin/adminnoticeinsert.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminNoticeInsertAction().execute(request, response);
      }

      // ????????? ???????????????
      else if (command.equals("/admin/adminrestaurant.did")) {
         System.out.println("?????? FCAdmin ?????????????????????");
         forward = new AdminRestaurantAction().execute(request, response);
      }

      // ????????? ?????? ???????????????
      else if (command.equals("/admin/adminrestaurantdetail.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminRestaurantDetailAction().execute(request, response);
      }

      // ????????? ?????? ??????
      else if (command.equals("/admin/adminrestaurantdelete.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminRestaurantDeleteAction().execute(request, response);
      }

      // ????????? ?????? ??????
      else if (command.equals("/admin/adminrestaurantsearch.did")) {
         System.out.println("?????? FCAdmin ??????????????????");
         forward = new AdminRestaurantSearchAction().execute(request, response);
      }

      else {
         throw new ServletException("command ????????????!");
      }

      if (forward != null) {
         if (forward.isRedirect()) {
            response.sendRedirect(forward.getPath());
         } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
            dispatcher.forward(request, response);
         }
      }

      PrintWriter out = response.getWriter();
      out.println("<script>alert('command ??????????????????!');history.go(-1);</script>");
   }

}