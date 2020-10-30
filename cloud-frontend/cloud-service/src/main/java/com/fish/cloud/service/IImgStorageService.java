package com.fish.cloud.service;

import com.fish.cloud.common.ret.TupleRet;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 图片存储
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IImgStorageService {
    /**
     * 存储
     * @param file
     * @return
     */
    TupleRet store(MultipartFile file) throws IOException;
}
