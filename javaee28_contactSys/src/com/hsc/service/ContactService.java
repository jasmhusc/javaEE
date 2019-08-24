package com.hsc.service;

import com.hsc.dao.IContactDao;
import com.hsc.entity.Contact;
import com.hsc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 业务逻辑层，调用dao层的api，执行业务逻辑，返回结果。
public class ContactService {

    // 查找出所有用户
    public List<Contact> findAllContacts() {
        // 业务较简单，直接调用一个方法即可。
        SqlSession session = MybatisUtils.getSession();
        IContactDao contactDao = session.getMapper(IContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        MybatisUtils.closeSession(session);
        return contacts;
    }

    // 根据id查找一个联系人
    public Contact findContact(int id) {
        SqlSession session = MybatisUtils.getSession();
        IContactDao contactDao = session.getMapper(IContactDao.class);
        Contact contact = contactDao.findById(id);
        MybatisUtils.closeSession(session);
        return contact;
    }

    // 更新联系人
    public void updateContact(Contact contact) {
        SqlSession session = MybatisUtils.getSession();
        IContactDao contactDao = session.getMapper(IContactDao.class);
        contactDao.update(contact);
        MybatisUtils.closeSession(session);
    }

    // 添加联系人
    public void addContact(Contact contact) {
        SqlSession session = MybatisUtils.getSession();
        IContactDao contactDao = session.getMapper(IContactDao.class);
        contactDao.add(contact);
        MybatisUtils.closeSession(session);
    }

    // 删除联系人
    public void deleteContact(int id) {
        SqlSession session = MybatisUtils.getSession();
        IContactDao contactDao = session.getMapper(IContactDao.class);
        contactDao.delete(id);
        MybatisUtils.closeSession(session);
    }
}
