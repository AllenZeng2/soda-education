package com.soda.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Menu;
import com.soda.entity.Role;
import com.soda.service.MenuService;
import com.soda.service.RoleService;
import com.soda.service.impl.MenuServiceImpl;
import com.soda.service.impl.RoleServiceImpl;

public class RoleControl {
	private RoleService rs = new RoleServiceImpl();

	private MenuService ms = new MenuServiceImpl();

	public void selectRoles(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ro_name = request.getParameter("ro_name");
		String state = request.getParameter("ro_state");
		String page = request.getParameter("page");

		// 查询信息类
		ConditionInfo cf = new ConditionInfo();

		cf.setLoginName(ro_name);
		cf.setItemsEveryPage(5);
		// 设置当前页为第一页
		cf.setCurrentPage(1);
		// 判断page是否为空或双引号,主要是防止非链接访问
		if (page != null && page.length() > 0) {
			cf.setCurrentPage(Integer.parseInt(page));

		}
		// 对"全部"进行处理
		if (state == null || state.length() == 0) {
			cf.setState(2);
		} else {
			cf.setState(Integer.parseInt(state));
		}
		// 查询得到查询的count,并赋值
		cf.setTotalCount(rs.getTotalPages(cf));

		// 对count+9在整除,获得页数
		cf.setTotalPages((cf.getTotalCount() + 4) / cf.getItemsEveryPage());
		// 防止查询无结果
		if (cf.getTotalPages() < 1)
			cf.setTotalPages(1);

		// 防止首页和尾页跳出
		if (cf.getCurrentPage() < 1) {
			cf.setCurrentPage(1);
		}
		if (cf.getCurrentPage() > cf.getTotalPages()) {
			cf.setCurrentPage(cf.getTotalPages());
		}
		// 根据传入的param值相应操作

		List<Role> roles = rs.selectRoles(cf);

		if (roles.size() <= 0)
			roles = null;

		request.setAttribute("info", cf);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("houtai/pages/role/list.jsp").forward(
				request, response);

	}

	// 单个详情
	public void detailOfRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("re_id");
		String num = request.getParameter("num");
		if (id != null && id.length() > 0) {
			Role role = rs.selectRoleById(Integer.parseInt(id));
			List<Fmenu> fms = ms.selecFmenus();
			int len = fms.size();
			for (int i = 0; i < len; i++) {
				int fid = fms.get(i).getFmen_id();
				List<Menu> mes = ms.selectMenusOfFmenu(fid);
				fms.get(i).setMenu(mes);
			}

			request.setAttribute("role", role);
			if (Integer.parseInt(num) == 1)
				request.getRequestDispatcher("houtai/pages/role/detail.jsp")
						.forward(request, response);
			if (Integer.parseInt(num) == 2) {
				// List<Menu> menus=role.getMenus();
				// if(menus==null)
				// System.out.println("null");
				// request.setAttribute("menus", menus);
				request.setAttribute("fms", fms);
				request.getRequestDispatcher("houtai/pages/role/edit.jsp")
						.forward(request, response);

			}
		}

	}

	// 改变状态
	public void updateRole(HttpServletRequest request,
			HttpServletResponse response) {
		String num = request.getParameter("num");
		String id = request.getParameter("uid");

		if (id != null && id.length() > 0) {

			rs.updateStateOfRole(Integer.parseInt(id), Integer.parseInt(num));

		}

	}

	// 添加角色
	public void addRole(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String ro_name = request.getParameter("ro_name");
		String[] checkbox = request.getParameterValues("checkbox");
		String[] checkbox11 = request.getParameterValues("checkbox11");
		String ro_state = request.getParameter("ro_state");
		String ro_remark = request.getParameter("ro_remark");

		Role role = new Role();
		if (ro_name != null && ro_name.length() > 0)
			role.setRe_name(ro_name);
		if (ro_state != null && ro_state.length() > 0)
			role.setRe_state(Integer.parseInt(ro_state));
		role.setRe_remark(ro_remark);
		rs.addRole(role);
		// 搜查添加到角色
		Role r2 = rs.selectRoleByName(ro_name);
		int re_id = r2.getRe_id();
		if (checkbox != null) {
			for (int i = 0; i < checkbox.length; i++) {
				int fm_id = Integer.parseInt(checkbox[i]);
				rs.addFmenuOfRole(fm_id, re_id);
			}
		}
		if (checkbox11 != null) {
			for (int i = 0; i < checkbox11.length; i++) {
				int mu_id = Integer.parseInt(checkbox11[i]);
				rs.addMenuOfRole(re_id, mu_id);
			}
		}

		response.sendRedirect("houtai/pages/role/list.jsp");
	}

	// 废除的添加角色
	/*
	 * public void addRole(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException {
	 * 
	 * String ro_name=request.getParameter("ro_name"); String[]
	 * checkbox=request.getParameterValues("checkbox"); String[]
	 * checkbox11=request.getParameterValues("checkbox11"); String[]
	 * checkbox21=request.getParameterValues("checkbox21"); String
	 * ro_state=request.getParameter("ro_state"); String
	 * ro_remark=request.getParameter("ro_remark");
	 * 
	 * Role role=new Role(); if(ro_name!=null&&ro_name.length()>0)
	 * role.setRe_name(ro_name); if(ro_state!=null&&ro_state.length()>0)
	 * role.setRe_state(Integer.parseInt(ro_state));
	 * role.setRe_remark(ro_remark); rs.addRole(role); //搜查添加到角色 Role
	 * r2=rs.selectRoleByName(ro_name); int re_id=r2.getRe_id();
	 * if(checkbox!=null){ for (int i = 0; i < checkbox.length; i++) { int
	 * fm_id=Integer.parseInt(checkbox[i]); rs.addFmenuOfRole(fm_id,re_id); } }
	 * if(checkbox11!=null){ for (int i = 0; i < checkbox11.length; i++) { int
	 * mu_id=Integer.parseInt(checkbox11[i]); rs.addMenuOfRole(re_id,mu_id); } }
	 * if(checkbox21!=null){ for (int i = 0; i < checkbox21.length; i++) { int
	 * mu_id=Integer.parseInt(checkbox21[i]); rs.addMenuOfRole(re_id,mu_id); } }
	 * 
	 * response.sendRedirect("houtai/pages/role/list.jsp");
	 * 
	 * }
	 */
	// 检查角色名
	public void checkName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name = new String(request.getParameter("name").getBytes(
				"ISO-8859-1"), "utf-8");
		if (name.length() == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("fail");
			return;
		}
		if (name != null) {
			Role r3 = rs.selectRoleByName(name);
			if (r3 != null) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
			}
		}
	}

	// 编辑
	public void editRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ro_name = request.getParameter("ro_name");
		String re_id = request.getParameter("re_id");
		String ro_state = request.getParameter("ro_state");
		String ro_remark = request.getParameter("ro_remark");
		// String[] menus=request.getParameterValues("menus");
		// String[] fmenus=request.getParameterValues("fmenus");

		String[] checkbox = request.getParameterValues("checkbox");
		String[] checkbox11 = request.getParameterValues("checkbox11");
		// String[] checkbox21=request.getParameterValues("checkbox21");
		// String[] checkbox31=request.getParameterValues("checkbox31");
		// String[] checkbox41=request.getParameterValues("checkbox41");

		int id = -1;
		if (re_id != null && re_id.length() > 0)
			id = Integer.parseInt(re_id);
		Role role = new Role();
		role.setRe_id(id);
		role.setRe_name(ro_name);
		role.setRe_state(Integer.parseInt(ro_state));
		role.setRe_remark(ro_remark);

		Role role2 = rs.selectRoleById(id);
		// 修改角色
		rs.editRole(role);

		if (checkbox11 != null) {
			// 删除所有子菜单,再重新添加
			rs.deleteMenus(id);
			for (int i = 0; i < checkbox11.length; i++) {
				int mu_id = Integer.parseInt(checkbox11[i]);
				rs.addMenuOfRole(id, mu_id);
			}
			if (role2 != null) {
				List<Fmenu> fms = role2.getFmenu();
				int len = fms.size();
				// 判断主菜单集合是否为空
				if (fms != null) {
					for (int i = 0; i < len; i++) {
						// 判断主菜单是否含有子菜单,如果没有,则删除
						if (fms.get(i).getMenu() == null) {
							int fm_id = fms.get(i).getFmen_id();
							rs.deleteFmenus(id);
						}
					}
				}
			}
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('修改成功');location.href='houtai/pages/role/list.jsp';");
		out.print("</script>");
	}

	// 多项删除
	public void mutipleDelRole(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String[] ids = request.getParameterValues("checkbox2");
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				rs.updateStateOfRole(Integer.parseInt(ids[i]), num);
			}
			// response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('删除成功')");
			out.print("</script>");
			selectRoles(request, response);
		}

	}

	public void selectRoleForAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Role> roles = rs.selectRoleForAdd();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("houtai/pages/role/add.jsp").forward(
				request, response);
	}

	// 查询菜单(添加的时候)
	public void selectMenuForAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Fmenu> fms = ms.selecFmenus();
		// ConditionInfo cf=null;
		// List<Menu> menus=ms.selectMenus(cf);
		int len = fms.size();
		for (int i = 0; i < len; i++) {
			int id = fms.get(i).getFmen_id();
			List<Menu> mes = ms.selectMenusOfFmenu(id);
			fms.get(i).setMenu(mes);
		}
		request.setAttribute("fmenus", fms);
		request.getRequestDispatcher("houtai/pages/role/add.jsp").forward(
				request, response);
	}
	//编辑重名
	public void checkEditName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = new String(request.getParameter("name").getBytes(
				"ISO-8859-1"), "utf-8");
		Integer id=Integer.parseInt(request.getParameter("reid"));
		if (name.length() == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("fail");
			return;
		}
		if (name != null) {
			Role r3 = rs.selectRoleByName(name);
			if (r3 != null&&r3.getRe_id()!=id) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
			}
		}
		
	}
}
