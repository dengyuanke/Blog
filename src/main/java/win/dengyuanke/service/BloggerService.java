package win.dengyuanke.service;

import win.dengyuanke.entity.Blogger;

public interface BloggerService {
	/**
	 * ͨ���û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);

	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
	public Blogger find();
}
