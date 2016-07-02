/*
 *
 * author : Nguyen Dong Hung, Nguyen Hong Nhut
 * 
 * 
*/
package com.csc.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.csc.model.*;
import com.csc.service.DealService;
import com.csc.service.ItemService;
import com.csc.service.SendEmailService;
import com.csc.service.TypeService;
import com.csc.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/api/deal")
public class DealAPIController {
	@Autowired
	@Qualifier("dealService")
	private DealService dealService;
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;
	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	@Autowired
	@Qualifier("sendService")
	private SendEmailService mail ;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public void insertDeal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Gson gson = new Gson();
		ResultObject result;
		try {
			if (req.getSession().getAttribute("userId") != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
				TBL_Deal deal = new TBL_Deal();
				deal.setDeal_owner(req.getParameter("deal_owner"));
				deal.setDeal_begin(formatter.parse(req.getParameter("deal_begin")));
				deal.setDeal_end(formatter.parse(req.getParameter("deal_end")));
				deal.setDeal_price(Double.parseDouble(req.getParameter("deal_price")));
				deal.setDeal_discount(Float.parseFloat(req.getParameter("deal_discount")));
				deal.setDeal_amount(Double.parseDouble(req.getParameter("deal_amount")));
				deal.setDeal_acceptable(Float.parseFloat(req.getParameter("deal_acceptable")));
				deal.setDeal_description(req.getParameter("deal_description"));
				deal.setDeal_status(req.getParameter("deal_status"));
				TBL_Item item = itemService.getItemByID(Long.parseLong(req.getParameter("item_id")));
				deal.setTbl_item(item);
				TBL_User user = userService
						.getUserByID(Long.parseLong(req.getSession().getAttribute("userId").toString()));
				deal.setTbl_user(user);
				TBL_Deal newDeal = dealService.insertDeal(deal);
				newDeal.getTbl_item().setTbl_deals(null);
				newDeal.getTbl_item().setTbl_type(null);
				newDeal.getTbl_user().setTbl_items(null);
				newDeal.getTbl_user().setTbl_orders(null);
				newDeal.getTbl_user().setTbl_role(null);

				result = new ResultObject("success", newDeal);
				resp.getWriter().write(gson.toJson(result));
			} else {
				result = new ResultObject("failed", "User Must Login in order to use this function!");
				resp.getWriter().write(gson.toJson(result));
			}
		} catch (Exception ex) {
			result = new ResultObject("failed", ex.getMessage());
			resp.getWriter().write(gson.toJson(result));
			ex.printStackTrace();
		}

	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public void updateDeal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		TBL_DealSerializer.setRequest(req);
		Gson gson = new Gson();
		ResultObject result;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
			TBL_Deal deal = dealService.getDealById(Long.parseLong(req.getParameter("deal_id")));
			deal.setDeal_owner(req.getParameter("deal_owner"));
			deal.setDeal_begin(formatter.parse(req.getParameter("deal_begin")));
			deal.setDeal_end(formatter.parse(req.getParameter("deal_end")));
			deal.setDeal_price(Double.parseDouble(req.getParameter("deal_price")));
			deal.setDeal_discount(Float.parseFloat(req.getParameter("deal_discount")));
			deal.setDeal_amount(Double.parseDouble(req.getParameter("deal_amount")));
			deal.setDeal_acceptable(Float.parseFloat(req.getParameter("deal_acceptable")));
			deal.setDeal_description(req.getParameter("deal_description"));
			deal.setDeal_status(req.getParameter("deal_status"));
			TBL_Item item = itemService.getItemByID(Long.parseLong(req.getParameter("item_id")));
			deal.setTbl_item(item);
			TBL_User user = userService.getUserByID(Long.parseLong(req.getSession().getAttribute("userId").toString()));
			deal.setTbl_user(user);
			dealService.insertDeal(deal);
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Deal.class, new TBL_DealSerializer());
			gsonBuilder.registerTypeAdapter(ImageDeal.class, new ImageDealSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();

			result = new ResultObject("success", deal);
			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			result = new ResultObject("failed", ex.getMessage());
			resp.getWriter().write(gson.toJson(result));
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteDeal(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		ResultObject result;
		try {
			String[] listId = req.getParameterValues("listOrderId");

			for (String id : listId) {
				dealService.deleteDeal(Long.parseLong(id));
			}
			result = new ResultObject("success", "delete successfully deal");
			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getallDeal(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		List<TBL_Deal> list = dealService.allDeal();

		PrintWriter writter;
		try {
			for (TBL_Deal tbl_Deal : list) {
				tbl_Deal.getTbl_item().setTbl_deals(null);
				tbl_Deal.getTbl_item().setTbl_type(null);
				tbl_Deal.getTbl_user().setTbl_items(null);
				tbl_Deal.getTbl_user().setTbl_orders(null);
				tbl_Deal.getTbl_user().setTbl_role(null);
			}

			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			writter.write(gson.toJson(list));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getPagination", method = RequestMethod.GET)
	public void getPaginationDeal(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();

		String start = req.getParameter("start");
		String sizePagination = req.getParameter("sizePagination");
		List<TBL_Deal> listDeal = dealService.getPaginationDeal(Integer.parseInt(start),
				Integer.parseInt(sizePagination));
		PrintWriter writter;

		try {
			for (TBL_Deal tbl_Deal : listDeal) {
				tbl_Deal.getTbl_item().setTbl_deals(null);
				tbl_Deal.getTbl_item().setTbl_type(null);
				tbl_Deal.getTbl_user().setTbl_items(null);
				tbl_Deal.getTbl_user().setTbl_orders(null);
				tbl_Deal.getTbl_user().setTbl_role(null);
			}

			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			writter.write(gson.toJson(listDeal));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getNumberPage", method = RequestMethod.GET)
	public void getNumberPage(HttpServletRequest req, HttpServletResponse resp) {
		String size = req.getParameter("sizePagination");
		int sizePagination = Integer.parseInt(size);
		Gson gson = new Gson();
		PrintWriter writter;
		try {
			writter = resp.getWriter();
			int sizeReal = dealService.getSizeDeal() % sizePagination == 0 ? dealService.getSizeDeal() / sizePagination
					: dealService.getSizeDeal() / sizePagination + 1;
			ResultObject result = new ResultObject("numberPage", sizeReal);
			writter.write(gson.toJson(result));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getDealByItemId", method = RequestMethod.GET)
	public void getDealByItemId(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		String item_id = req.getParameter("item_id");
		List<TBL_Deal> list = dealService.getDealbyItem(Long.parseLong(item_id));

		PrintWriter writter;
		try {
			if (list.size() > 0) {
				for (TBL_Deal tbl_Deal : list) {
					tbl_Deal.getTbl_item().setTbl_deals(null);
					tbl_Deal.getTbl_item().setTbl_type(null);
					tbl_Deal.getTbl_user().setTbl_items(null);
					tbl_Deal.getTbl_user().setTbl_orders(null);
					tbl_Deal.getTbl_user().setTbl_role(null);
				}

				resp.setCharacterEncoding("UTF-8");
				writter = resp.getWriter();
				ResultObject result = new ResultObject("success", list);
				writter.write(gson.toJson(result));

				writter.flush();
				writter.close();
			} else {
				writter = resp.getWriter();
				ResultObject result = new ResultObject("success", "No deal for this item");
				writter.write(gson.toJson(result));

				writter.flush();
				writter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getbybegintime", method = RequestMethod.GET)
	public void getallDealSortByBT(HttpServletRequest req, HttpServletResponse resp) {
		TBL_DealSerializer.setRequest(req);
		Gson gson = new Gson();
		String status = req.getParameter("status");
		if(status == null){
			status = "";
		}
		List<TBL_Deal> list = dealService.allDealSort("deal_begin", Integer.parseInt(req.getParameter("start")),
				Integer.parseInt(req.getParameter("numberget")), req.getParameter("sort"),status);

		PrintWriter writter;
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Deal.class, new TBL_DealSerializer());
			gsonBuilder.registerTypeAdapter(ImageDeal.class, new ImageDealSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();

			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<TBL_Deal>>() {
			}.getType();

			JsonElement el = gson.toJsonTree(list, typeOfSrc);
			writter.write(gson.toJson(list, typeOfSrc));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getbyendtime", method = RequestMethod.GET)
	public void getallDealSortByET(HttpServletRequest req, HttpServletResponse resp) {
		TBL_DealSerializer.setRequest(req);
		Gson gson = new Gson();
		String status = req.getParameter("status");
		if(status == null){
			status = "";
		}
		List<TBL_Deal> list = dealService.allDealSort("deal_end", Integer.parseInt(req.getParameter("start")),
				Integer.parseInt(req.getParameter("numberget")), req.getParameter("sort"), status);

		PrintWriter writter;
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(TBL_Deal.class, new TBL_DealSerializer());
			gsonBuilder.registerTypeAdapter(ImageDeal.class, new ImageDealSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();

			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<TBL_Deal>>() {
			}.getType();

			writter.write(gson.toJson(list, typeOfSrc));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public void select(@PathVariable long id, HttpServletResponse resp) {
		Gson gson = new Gson();
		TBL_Deal deal = dealService.getDealById(id);

		PrintWriter writter;
		try {
			deal.getTbl_item().setTbl_deals(null);
			deal.getTbl_item().setTbl_type(null);
			deal.getTbl_user().setTbl_items(null);
			deal.getTbl_user().setTbl_orders(null);
			deal.getTbl_user().setTbl_role(null);

			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			writter.write(gson.toJson(deal));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getnumberdeal", method = RequestMethod.GET)
	public void getNumberDeal(HttpServletRequest req, HttpServletResponse resp) {
		Gson gson = new Gson();
		int size = dealService.getSizeDeal();

		PrintWriter writter;
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

			writter.write(gson.toJson(new ResultObject("size", size)));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getallimagebt", method = RequestMethod.GET)
	public void getImageDealByBT(HttpServletRequest request, HttpServletResponse response) {
		List<TBL_Deal> list = dealService.allDeal();
		Comparator<TBL_Deal> sortByTime = new Comparator<TBL_Deal>() {

			@Override
			public int compare(TBL_Deal o1, TBL_Deal o2) {
				return o1.getDeal_begin().compareTo(o2.getDeal_begin());
			}

		};

		List<ImageDeal> images = new ArrayList<ImageDeal>();
		for (TBL_Deal dealEle : list) {
			ImageDeal imageDeal = new ImageDeal();
			File folder = new File(request.getSession().getServletContext().getRealPath("/") + "resources\\image\\"
					+ dealEle.getDeal_id());
			if(!folder.exists()){
				break;
			}
			String[] nameOfFiles = folder.list();
			int[] witdhOfImages = new int[nameOfFiles.length];
			int[] heightOfImages = new int[nameOfFiles.length];

			for (int i = 0; i < nameOfFiles.length; i++) {
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File(folder + "\\" + nameOfFiles[i]));
				} catch (IOException e) {
					e.printStackTrace();
				}
				witdhOfImages[i] = img.getWidth();
				heightOfImages[i] = img.getHeight();

			}

			imageDeal.setDeal_id(dealEle.getDeal_id());
			imageDeal.setNumber(nameOfFiles.length);
			imageDeal.setImage_name(nameOfFiles);
			imageDeal.setImage_witdh(witdhOfImages);
			imageDeal.setImage_height(heightOfImages);
			System.out.println(folder);

			images.add(imageDeal);

		}
		PrintWriter writter;
		Gson gson = new Gson();
		try {
			response.setCharacterEncoding("UTF-8");
			writter = response.getWriter();

			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<ImageDeal>>() {
			}.getType();

			writter.write(gson.toJson(images, typeOfSrc));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
	public void cancleDeal(@PathVariable Long id, HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		ResultObject result;
		Gson gson = new Gson();
		try {
			System.out.println("-------------" + id);

			if (id != null) {
				TBL_Deal deal = dealService.getDealById(id);
				deal.setDeal_status("CANCEL");
				dealService.updateDeal(deal);
				List<TBL_User> user = dealService.getListUser(deal);

				System.out.println(user.size());
				
					for (TBL_User users : user)
					{
							String bodymail = "Hi "+ users.getUser_name()
						+ "We send mail to confirm that we will destroy your deal  "
						+ "because your deal is not enough number of buyer "
						+ " Sorry about that , we will update as soon as posible "
						+" Let's buy a new deal , we have some offer very hot !"
						+"Best regards "
						+"Thanks for use we service"
						+"X Team Developer"
						+"Hung";
						String subject = "X Team For Destroy Deal";
						String FromAddress = "chickenmanbhd@gmail.com" ;
						String ToAddress = users.getUser_email() ;
						mail.ReadyToSendEmail(ToAddress, FromAddress, subject, bodymail);
							
					}
				result = new ResultObject("success", "Update Success");
				resp.getWriter().write(gson.toJson(result));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = new ResultObject("failed", e.getMessage());
			resp.getWriter().write(gson.toJson(result));
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "/active/{id}", method = RequestMethod.POST)
	public void activeDeal(@PathVariable Long id,HttpServletRequest reg, HttpServletResponse resp) throws IOException {
		Gson gson = new Gson();
		ResultObject result;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM,yyyy");
			TBL_Deal deal = dealService.getDealById(id);
			System.out.println(reg.getParameter("deal_end"));
			
			deal.setDeal_end(formatter.parse(reg.getParameter("deal_end")));
			deal.setDeal_status(reg.getParameter("deal_status"));

			dealService.updateDeal(deal);	

			result = new ResultObject("success", "Update Success");
			resp.getWriter().write(gson.toJson(result));
		} catch (Exception ex) {
			result = new ResultObject("failed", ex.getMessage());
			resp.getWriter().write(gson.toJson(result));
			ex.printStackTrace();
		}

	}

	@RequestMapping(value = { "/upload/{id}" }, method = RequestMethod.POST)
	public void uploadDeal(MultipartHttpServletRequest req, HttpServletResponse resp, @PathVariable long id)
			throws Exception {
		try {
			MultipartFile multipartFile = req.getFile("deal_image");
			java.io.InputStream stream = multipartFile.getInputStream();

			File folder = new File(
					req.getSession().getServletContext().getRealPath("/") + "resources\\image\\" + String.valueOf(id));
			if (!folder.exists()) {
				folder.mkdirs();
			}
			File img = new File(req.getSession().getServletContext().getRealPath("/") + "resources\\image\\"
					+ String.valueOf(id) + "\\" + multipartFile.getOriginalFilename());
			if (img.createNewFile()) {
				Path target = Paths.get(req.getSession().getServletContext().getRealPath("/") + "resources\\image\\"
						+ String.valueOf(id) + "\\" + multipartFile.getOriginalFilename());
				Files.copy(stream, target, StandardCopyOption.REPLACE_EXISTING);

				stream.close();

				ResultObject result = new ResultObject("success", multipartFile.getOriginalFilename());
				Gson gson = new Gson();
				resp.getWriter().write(gson.toJson(result));
			}else {
				ResultObject result = new ResultObject("failed", "can not create file");
				Gson gson = new Gson();
				resp.getWriter().write(gson.toJson(result));
			}
		} catch (Exception ex) {
			ResultObject result = new ResultObject("failed", ex.getMessage());
			Gson gson = new Gson();
			resp.getWriter().write(gson.toJson(result));
		}
	}
	
	@RequestMapping(value = { "/getdatachart" }, method = RequestMethod.POST)
	public void getDataChart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		String link = req.getParameter("type");
//		System.out.println(link);
//		if(link.equalsIgnoreCase("topDealAmount")){
//			
//		}
		Gson gson = new Gson();

		List<ResultObject> list = dealService.getDataDraw("", "");

		PrintWriter writter;
		try {
			resp.setCharacterEncoding("UTF-8");
			writter = resp.getWriter();

//			GsonBuilder gsonBuilder = new GsonBuilder();
//			gsonBuilder.registerTypeAdapter(TBL_Deal.class, new TBL_DealSerializer());
//			gsonBuilder.registerTypeAdapter(ImageDeal.class, new ImageDealSerializer());
//			gsonBuilder.registerTypeAdapter(TBL_Item.class, new TBL_ItemSerializer());
//			gsonBuilder.registerTypeAdapter(TBL_Type.class, new TBL_TypeSerializer());
//			gsonBuilder.setPrettyPrinting();
//			gson = gsonBuilder.create();

			java.lang.reflect.Type typeOfSrc = new TypeToken<Collection<ResultObject>>() {
			}.getType();

			writter.write(gson.toJson(list, typeOfSrc));

			writter.flush();
			writter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
