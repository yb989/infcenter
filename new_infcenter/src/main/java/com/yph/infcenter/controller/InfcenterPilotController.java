package com.yph.infcenter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yph.infcenter.common.util.DataMsg;
import com.yph.infcenter.entity.InfcenterPilot;
import com.yph.infcenter.service.InfcenterPilotService;
       
@Controller
@RequestMapping("/pilot")
public class InfcenterPilotController extends BaseController{
	
	@Autowired
	private InfcenterPilotService infcenterPilotService;
	
	/**
	 * 
	 * Description:跳转到栏目管理页面 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午11:06:14
	 */
	@RequestMapping(value="/toPilotList")
	public String toPilotList(String refreshTag,String messageCode,Model model){
		showMessageAlert(refreshTag,messageCode,model);
		return "app/pilot/pilot_tree";
	}
	
	/**
	 * 
	 * Description:查询所有栏目信息
	 *
	 * @param 
	 * @return Map<String,Object>
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午11:10:14
	 */
	@ResponseBody
	@RequestMapping(value="/queryPilots")
	public List<Map<String,Object>> queryPilots(){
		List<Map<String,Object>> mapPilot = infcenterPilotService.queryPilots();
		return mapPilot;
	}
     
	/**
	 * 
	 * Description:跳转到一级导航增加、修改录入页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午13:54:14
	 */
	@RequestMapping(value="/toInputPilot")
	public String toInputPilot(HttpServletRequest request){
		try{
			String parentId = request.getParameter("parentId");
			if( null != parentId){
				request.setAttribute("parentId", Integer.parseInt(parentId));
			}
			String id = request.getParameter("id");
			if( null != id){
				request.setAttribute("infcenterPilot", infcenterPilotService.queryByIdPilot(Integer.parseInt(id)));
			}
		}catch(Exception e){
			e.printStackTrace();
			return "common/exception";
		}
		return "app/pilot/pilot_input";
	}
	
	/**
	 * 
	 * Description:跳转到根目录增加、修改录入页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午13:54:14
	 */
	@RequestMapping(value="/toInputPilotFirst")
	public String toInputPilotFirst(HttpServletRequest request){
		try{
			String parentId = request.getParameter("parentId");
			if( null != parentId){
				request.setAttribute("parentId", Integer.parseInt(parentId));
			}
			String id = request.getParameter("id");
			if( null != id){
				request.setAttribute("infcenterPilot", infcenterPilotService.queryByIdPilot(Integer.parseInt(id)));
			}
		}catch(Exception e){
			e.printStackTrace();
			return "common/exception";
		}
		return "app/pilot/pilot_inputFirst";
	}
	
	
	/**
	 * 
	 * Description:跳转到二级导航目录增加、修改录入页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午13:54:14
	 */
	@RequestMapping(value="/toInputPilotTwo")
	public String toInputPilotTwo(HttpServletRequest request){
		try{
			String parentId = request.getParameter("parentId");
			if( null != parentId){
				request.setAttribute("parentId", Integer.parseInt(parentId));
			}
			String id = request.getParameter("id");
			if( null != id){
				request.setAttribute("infcenterPilot", infcenterPilotService.queryByIdPilot(Integer.parseInt(id)));
			}
		}catch(Exception e){
			e.printStackTrace();
			return "common/exception";
		}
		return "app/pilot/pilot_inputTwo";
	}
	
	/**
	 * 
	 * Description:栏目增加、修改录入页面
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午14:34:14
	 */
	@ResponseBody
	@RequestMapping(value="/doAddEditPilot")
	public DataMsg doAddEditPilot(@ModelAttribute InfcenterPilot infcenterPilot,DataMsg dataMsg,HttpSession session,HttpServletRequest request){
		
		try{
			int parent_Id ;
			if(null != infcenterPilot.getId()){
//				InfcenterPilot oldPilot=infcenterPilotService.queryByIdPilot(infcenterPilot.getId());
//				//如果有任意字段改动就删除保存路径下的一部分文件
//				//根目录
//				/**
//				 * suxuqiang
//				 */
//				if(!"".equals(oldPilot.getColumnZhName())&& !"".equals(oldPilot.getColumnUrl())&& !"".equals(oldPilot.getPageSavePath())){
//					if(!oldPilot.getColumnZhName().equals(infcenterPilot.getColumnZhName())
//						|| !oldPilot.getColumnUrl().equals(infcenterPilot.getColumnUrl())
//						|| !oldPilot.getPageSavePath().equals(infcenterPilot.getPageSavePath())){
//						List<String> list=new ArrayList<String>();
//						list.add("js");
//						list.add("css");
//						try {
//							DeleteFilesUtil.removeFiles(oldPilot.getPageSavePath(), list);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//				//一级目录
//				/**
//				 * suxuqiang
//				 */
//				if(!"".equals(oldPilot.getColumnZhName())&& !"".equals(oldPilot.getColumnUrl())&& !"".equals(oldPilot.getPageSavePath())&& !"".equals(oldPilot.getColumnEnName())){
//					if(!oldPilot.getColumnZhName().equals(infcenterPilot.getColumnZhName())
//						|| !oldPilot.getColumnUrl().equals(infcenterPilot.getColumnUrl())
//						|| !oldPilot.getPageSavePath().equals(infcenterPilot.getPageSavePath())
//						|| !oldPilot.getColumnEnName().equals(infcenterPilot.getColumnEnName())){
//						List<String> list=new ArrayList<String>();
//						list.add("js");
//						list.add("css");
//						String path=infcenterPilotService.queryByIdPilot(oldPilot.getParentId()).getPageSavePath();
//						try {
//							DeleteFilesUtil.removeFiles(path+oldPilot.getPageSavePath(), list);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//				//二级目录
//				/**
//				 * suxuqiang
//				 */
//				if(!"".equals(oldPilot.getColumnZhName())&& !"".equals(oldPilot.getColumnUrl())&& !"".equals(oldPilot.getPageSavePath())&& !"".equals(oldPilot.getColumnEnName())&& !"".equals(oldPilot.getVelocityName())){
//					if(!oldPilot.getColumnZhName().equals(infcenterPilot.getColumnZhName())
//						|| !oldPilot.getColumnUrl().equals(infcenterPilot.getColumnUrl())
//						|| !oldPilot.getPageSavePath().equals(infcenterPilot.getPageSavePath())
//						|| !oldPilot.getColumnEnName().equals(infcenterPilot.getColumnEnName())
//						|| !oldPilot.getVelocityName().equals(infcenterPilot.getVelocityName())){
//						List<String> list=new ArrayList<String>();
//						list.add("js");
//						list.add("css");
//						String twoLevelPath=oldPilot.getPageSavePath();						
//						String oneLevelPath=infcenterPilotService.queryByIdPilot(oldPilot.getParentId()).getPageSavePath();
//						String zeroLevelPath=infcenterPilotService.queryByIdPilot(infcenterPilotService.queryByIdPilot(oldPilot.getParentId()).getParentId()).getPageSavePath();						
//						try {
//							DeleteFilesUtil.removeFiles(zeroLevelPath+oneLevelPath+twoLevelPath, list);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
				
				infcenterPilotService.updateByPrimaryKeySelective(infcenterPilot);
				dataMsg.setMessageCode("0003");
			}else{
				infcenterPilot.setOperator(getSystemCurrentUser(session).getEmployeeId());
				infcenterPilot.setOperateTime(new Date());
				infcenterPilot.setIsEffective("1");
				String parentId = request.getParameter("parentId");
				
				//添加时，通过id查询获取网点最大排列数，当parentId为null时，设置为0；
				if(parentId == null){
					parent_Id  = 0; 
				}else{
					parent_Id =Integer.parseInt(parentId);
				}
				Integer maxColumnSort=infcenterPilotService.getMaxFirstPilot(parent_Id);
				
				//当查询出网点最大排列数为空时，把ColumnSort设置为1；
				if(maxColumnSort == null){
					maxColumnSort = 1;
				    infcenterPilot.setColumnSort(maxColumnSort);
				}else{
					infcenterPilot.setColumnSort(maxColumnSort+1);
				}
				infcenterPilotService.insertSelectivePolit(infcenterPilot);
				dataMsg.setMessageCode("0001");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description:删除栏目信息
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午15:57:14
	 */
	@ResponseBody
	@RequestMapping(value="/doDelPilot/{id}")
	public DataMsg doDelPilot(@PathVariable Integer id,DataMsg dataMsg){
		try{
			infcenterPilotService.deleteInfcenterPilot(id);
			dataMsg.setMessageCode("0005");
		}catch(Exception e){
			e.printStackTrace();
			dataMsg.setMessageCode("0006");
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description:下拉选项，获取站点信息
	 *
	 * @param 
	 * @return hashmap
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-11 下午18:30:14
	 */
	@ResponseBody
	@RequestMapping(value="/findFirstPilotInfo")
	public List<Map<String, Object>> findFirstPilotInfo() throws Exception {
		List<Map<String, Object>> list = null;
		try {
			list = infcenterPilotService.findFirstPilotInfo();
			Map<String, Object> tmpMap = new HashMap<String, Object>();
			tmpMap.put("id", "");
			tmpMap.put("column_zh_name", "--请选择--");
			list.add(0,tmpMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * Description: 下拉选项，获取栏目信息
	 *
	 * @param 
	 * @return hashmap
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-11 下午18:30:14
	 */
	@ResponseBody
	@RequestMapping(value="/findSubWorkPilotInfoById")
	public List<Map<String, Object>> findSubWorkPilotInfoById(@RequestParam Integer id) throws Exception {
		List<Map<String, Object>> list = null;
		try {
			list = new ArrayList<Map<String,Object>>();
			list = infcenterPilotService.findSubWorkPilotInfoById(id);
			Map<String, Object> tmpMap = new HashMap<String, Object>();
			tmpMap.put("id", "");
			tmpMap.put("column_zh_name", "--请选择--");
			list.add(0,tmpMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * Description: 查找级联菜单
	 *
	 * @param 
	 * @return hashmap
	 * @throws IOException 
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-11 下午18:30:14
	 */
	@ResponseBody
	@RequestMapping(value="/findVelocityNameById")
	public Map<String, Object> findVelocityNameById(@RequestParam Integer id){
		Map<String, Object> tmpMap = null;
		try {
			tmpMap = infcenterPilotService.findVelocityNameById(id);
			if(tmpMap != null && !tmpMap.isEmpty()){
				Object velocityName = tmpMap.get("velocity_name");
				tmpMap.clear();
				tmpMap.put("data", velocityName);   
			}else{
				tmpMap = new HashMap<String, Object>();
				tmpMap.put("data", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmpMap;
	}
	
	/**
	 * 根据ID取得上一条数据的排序号
	 * @param id
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="/queryMenuSort")
	public @ResponseBody String queryMenuSort(String sort,String parentId){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sort", sort);
		map.put("parentId", parentId);
		Map<String, Object> result = infcenterPilotService.queryMenuSort(map);
		return JSONObject.fromObject(result).toString();
	}
	/**
	 * 修改排序
	 * @param infcenterPilot1
	 * @param infcenterPilot2
	 * @return
	 */
	@RequestMapping(value="/editSortByPilot")
	public @ResponseBody String editSortByPilot(Integer id1,Integer id2,Integer sort1,Integer sort2){
		InfcenterPilot infcenterPilot1 = new InfcenterPilot();
		InfcenterPilot infcenterPilot2 = new InfcenterPilot();
		infcenterPilot1.setId(id1);
		infcenterPilot1.setColumnSort(sort1);
		infcenterPilot2.setId(id2);
		infcenterPilot2.setColumnSort(sort2);
		Integer result1 = infcenterPilotService.updateByPrimaryKeySelective(infcenterPilot1);
		Integer result2 = infcenterPilotService.updateByPrimaryKeySelective(infcenterPilot2);
		DataMsg dataMsg = new DataMsg();
		if(result1>0&&result2>0){
			dataMsg.setMessageCode("0");
		}else{
			dataMsg.setMessageCode("1");
		}
		return JSONObject.fromObject(dataMsg).toString();
	}
	
	/**
	 * 根据ID取得上一条数据的排序号
	 * @param id
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="/queryMenuSortByDown")
	public @ResponseBody String queryMenuSortByDown(String parentId,String sort){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sort", sort);
		map.put("parentId", parentId);
		Map<String, Object> result = infcenterPilotService.queryMenuSortByDown(map);
		return JSONObject.fromObject(result).toString();
	}
	
	/**
	 * 根据ID查找菜单
	 * @param id
	 * @return
	 */
	@RequestMapping("/findPilotById")
	public @ResponseBody String findPilotById(Integer id){
		Map<String, Object> result = infcenterPilotService.findPilotById(id);
		return JSONObject.fromObject(result).toString();
	}
}

