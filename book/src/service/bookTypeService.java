package service;

import java.util.List;

import dao.bookDAO;
import dao.bookTypeDAO;
import entity.bookType;

public class bookTypeService {
	//��ѯ����
	public List<bookType> getbookTypes(){
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryAll();
	}
	 /*ͨ�����ݿ�����������ͣ�������� ��ӳɹ�orʧ��*/
	public boolean addType(bookType bookType) {
		//���ж��û�������������������ݿ����Ƿ����ͬ���ģ����ڲ����ӣ�����������
		bookTypeDAO dao=new bookTypeDAO();
		//�������ж�
		bookType temp = dao.query(bookType.getTypeName());
		if(temp==null) {
			//������ ���
			int row = dao.insert(bookType);
			if(row>0) {
				//��ӳɹ�
				return true;
			}
		}

		return false;
	}
	/*�жϲ�ѯ��ɾ�����������Ƿ���ڲ��ܽ��и��£�ɾ��������*/
	//��ѯ��Ӧ������
	public bookType getbookType(int booktypeId) {
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryId(booktypeId);
	}
	public int getName(String typeName) {
		bookTypeDAO dao = new bookTypeDAO();
		bookType bookType=dao.query(typeName);
		if(bookType!=null) {
			return bookType.getTypeId();
		}else {
			return 0;
		}
	}
	public List<bookType> getbookType(String typeName) {
		bookTypeDAO dao=new bookTypeDAO();
		return dao.query2(typeName);
	}
	
	//����bookid��ѯ������Ϣ
	public bookType getbookName(int bookId) {
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryTypeName(bookId);
	}

	/*�޸���������*/
	public boolean modifyType(bookType bookType) {
		bookTypeDAO dao=new bookTypeDAO();
		bookType temp=dao.query(bookType.getTypeName());
		if(temp == null) {
			int row = dao.update(bookType);
			if(row >= 0) {
				return true;
			}
		}
		return false;
	}
	/*ɾ����������*/
	public boolean removeType(int bookTypeId) {
		//ɾ���������ͣ���ɾ��������������µ�����������Ȼ��ɾ���������
		bookDAO bdao=new bookDAO();
		int crow=bdao.delTypeID(bookTypeId);
		
		bookTypeDAO dao=new bookTypeDAO();
		int row = dao.del(bookTypeId);
		if(row>=0&&crow>=0) {
			return true;
		}
		return false;
	}
	public List<bookType> getBookType(int pageNo,int pageSize){
		bookTypeDAO dao = new bookTypeDAO();
		List<bookType> list = dao.query(pageNo, pageSize);
		return list;
	}
	public int getBookTypeLine() {
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryCount();
	}
}
