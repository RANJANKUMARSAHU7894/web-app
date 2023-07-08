
package com.rk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rk.model.Employee;

@Repository("empRepo")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jt;

	public static final String SELECT_QUERY = " SELECT EMPNO ,EMPNAME,JOB,SAL,DEPTNO FROM EMP3";

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> listEmp = jt.query(SELECT_QUERY, rs -> {
			List<Employee> list = new ArrayList<>();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				list.add(emp);
			}
			return list;

		});

		return listEmp;
	}

	public static final String INSERT_QUERY = "INSERT INTO EMP3(EMPNO,EMPNAME,JOB,SAL,DEPTNO) VALUES(EMP_SEQ.NEXTVAL,?,?,?,?)";

	@Override
	public int insertEmployee(Employee emp) {
		int count = jt.update(INSERT_QUERY, emp.getEmpname(), emp.getJob(), emp.getSal(), emp.getDeptno());
		return count;
	}

	public static final String EDIT_QUERY = "SELECT EMPNO,EMPNAME,JOB,SAL,DEPTNO FROM EMP3 WHERE EMPNO=?";

	@Override
	public Employee getEmployeeByEno(int no) {
		Employee object = jt.queryForObject(EDIT_QUERY, (rs, rowNum) -> {

			Employee e = new Employee();
			e.setEmpno(rs.getInt(1));
			e.setEmpname(rs.getNString(2));
			e.setJob(rs.getString(3));
			e.setSal(rs.getFloat(4));
			e.setDeptno(rs.getInt(5));
			return e;

		},

				no);
		return object;

	}

	public static final  String UPDATE_QUERY="UPDATE EMP3 SET EMPNAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	@Override
	public int updateEmpByno(Employee emp) {
		int update = jt.update(UPDATE_QUERY,emp.getEmpname(),emp.getJob(),emp.getSal(),emp.getDeptno(),emp.getEmpno());
		return update;
	}
	
	
	public static final String DELETE_QUERY="DELETE FROM EMP3 WHERE EMPNO=?";
	@Override
	public int deleteByEmpno(int no) {
		int update = jt.update(DELETE_QUERY, no);
		return update;
	}

}
