package com.jxy.store.controller;

import com.jxy.store.controller.ex.*;
import com.jxy.store.entity.User;
import com.jxy.store.service.IUserService;
import com.jxy.store.util.FileUtil;
import com.jxy.store.util.JsonResult;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    //没有BaseController之前的写法
//    @RequestMapping("reg")
//    public JsonResult<Void> reg(User user){
//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            iUserService.reg(user);
//            result.setCode(200);
//            result.setMessage("注册成功");
//        } catch (UserNameDuplicatedException e) {
//            result.setCode(4000);
//            result.setMessage("用户名重复");
//        } catch (InsertException e) {
//            result.setCode(4500);
//            result.setMessage("插入时异常");
//        }
//        return result;
//    }
    //继承BaseController后的写法
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        iUserService.reg(user);
        return new JsonResult<Void>(OK);

    }

    @RequestMapping("login")
    public JsonResult<User> login(User user, HttpSession session) {
        User data = iUserService.login(user.getUsername(), user.getPassword());
        //向session对象中完成数据的绑定（全局的）
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        //暂时没使用，需要在BaseController里面写上对应的session
        session.setAttribute("password", data.getPassword());
        session.setAttribute("avatar", data.getAvatar());
//        System.out.println(getUidFromSession(session));
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(HttpSession session, String oldPassword, String newPassword) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        iUserService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        User data = iUserService.getByUid(uid);
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(HttpSession session, User user) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        iUserService.changeInfo(uid, username, user);
        return new JsonResult<Void>(OK);
    }

    //上传的文件的大小限制   10M  默认的是字节单位
    public static final int AVATAR_MAX_SIZE = 1024 * 1024 * 10;
    //上传的类型限制
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/gif");
    }


    /**
     * MultipartFile是SpringMvc 为我们提供的一个接口，这个接口为我们包装了获取文件的类型的数据
     * （任何累心的file都可以接收）
     * 只需要在处理请求的方法参数列表上声明一个参数类型为MultipartFile的参数，然后SpringBoot会自动的将文件数据赋值给这个参数
     *
     * @param session
     * @param file
     * @return
     */
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file) {
        //先判断文件是否为空
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空/文件大小为0字节");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件大小超出限制（大于10M）");
        }
        //拿到文件的类型/后缀
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不符合规范");
        }

        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);
        if(!dir.exists()){
            //如果不存在则创建一个文件夹
            dir.mkdirs();
        }
        //获取到原始文件名   abc.png
        String originalFilename = file.getOriginalFilename();
        //获取到最后一个 .
        int index = originalFilename.lastIndexOf(".");
        //截取最后一个 . 之后的   .png
        String suffix = originalFilename.substring(index);
        //通过UUID随机生成文件名
        String fileName = UUID.randomUUID().toString().toUpperCase() + suffix;
        //生成文件
        File dest = new File(dir, fileName);
        try {
            file.transferTo(dest);
        } catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        } catch (IOException e) {
//            e.printStackTrace();
            throw new FileUploadIOException("文件上传/下载异常");
        }
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        //用户头像的路径
        String avatar = "/upload/"+fileName;
        iUserService.changeAvatar(uid,avatar,username);
        //返回用户头像的信息
        return new JsonResult<String>(OK,avatar);
    }

}
