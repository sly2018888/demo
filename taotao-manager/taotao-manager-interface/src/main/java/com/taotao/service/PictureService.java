package com.taotao.service;

import com.taotao.common.pojo.PictureResult;

public interface PictureService {

	/**
	 *   0表示成功，1表示失败
	 * @param bytes
	 * @param name
	 * @return
	 */
	PictureResult uploadFile(byte[] bytes, String name);
}
