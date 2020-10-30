package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Table;
import com.fish.cloud.repo.TableMapper;
import com.fish.cloud.service.ITableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements ITableService {
	
}
