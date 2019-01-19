package jp.co.systena.tigerscave.SpringHelloSystena.application.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.SpringHelloSystena.application.model.Item;
import jp.co.systena.tigerscave.SpringHelloSystena.application.model.ListService;
import jp.co.systena.tigerscave.SpringHelloSystena.application.model.UserForm;

@Controller  // Viewあり。Viewを返却するアノテーション
public class UserListController {

  @Autowired
  HttpSession session;                  // セッション管理

  @RequestMapping(value="/userlist", method = RequestMethod.GET)          // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {
    // Viewに渡すデータを設定
    // セッション情報から保存したデータを取得してメッセージを生成
    UserForm userForm = (UserForm) session.getAttribute("form");
    session.removeAttribute("form");
    if (userForm != null) {
      mav.addObject("message", userForm.getName()+"を保存しました");
    }
    mav.addObject("userForm", new UserForm());  // 新規クラスを設定

    @SuppressWarnings("unchecked")
    List<Item> items = (List<Item>) session.getAttribute("userList");//商品を持ってきてusersに設定→item
    List<Item> item = ListService.getItemlist();
    if( items == null) {
        items = new ArrayList<Item>();
        session.setAttribute("userList", items);
    }
    mav.addObject("users", items);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }
    // Viewのテンプレート名を設定
    mav.setViewName("userlist");
    return mav;
  }

  @RequestMapping(value="/userlist", method = RequestMethod.POST)  // URLとのマッピング
  private ModelAndView adduser(ModelAndView mav, @Valid UserForm userForm, BindingResult bindingResult, HttpServletRequest request) {

    List<Item> items = (List<Item>)session.getAttribute("userList");
    if( items == null) {
        items = new ArrayList<Item>();
        session.setAttribute("userList", items);
    }

    if (bindingResult.getAllErrors().size() > 0) {
      // エラーがある場合はそのまま戻す
      mav.addObject("userForm",userForm);  // 新規クラスを設定

      mav.addObject("users", items);

      // Viewのテンプレート名を設定
      mav.setViewName("userlist");
      return mav;

    }
    Item item = new Item();
    item.setName(userForm.getName());
    items.add(item);
    // データをセッションへ保存
    session.setAttribute("form", userForm);
    return new ModelAndView("redirect:/userlist");        // リダイレクト
  }
}
