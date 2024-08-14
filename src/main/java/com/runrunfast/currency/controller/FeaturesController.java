package com.runrunfast.currency.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.runrunfast.currency.entity.Features;
import com.runrunfast.currency.entity.Result;
import com.runrunfast.currency.service.impl.FeaturesServiceImpl;
import com.runrunfast.currency.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 邹智敏
 * @since 2018-11-08
 */
@RestController
@RequestMapping("/features")
@Api(tags="用户特征管理",description="<font color='red'>【功能】分页查询、单个查询、按条件查询、查询所有、查询总记录数、单个新增、单个修改、单个删除、批量删除、按条件删除</font>")
public class FeaturesController {

    @Autowired
    private FeaturesServiceImpl featuresService;

    /***
     * <p>@author: James</p>
     * <p>@param: [pageNum, pageSize]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 14:17</P>
     * <p>@description: 用户分页查询</p>
     */
    @PostMapping("/getUserList/{pageNum}/{pageSize}")
    @ApiOperation(value = "分页",notes = "用户分页查询，默认是1页10条记录")
    public Result getUserList(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        //开始设置分页参数
        IPage<Features> page = new Page();
        //设置当前页数
        page.setCurrent(pageNum);
        //设置当前大小
        page.setSize(pageSize);
        return ResultUtil.success(featuresService.page(page,null),"查询");
    }

    /***
     * <p>@author: James</p>
     * <p>@param: [id]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 18:18</P>
     * <p>@description: 根据id查询</p>
     */
    @PostMapping("/getUserList/{id}")
    @ApiOperation(value = "查询",notes = "用户单个查询")
    public Result getUserList(@PathVariable Integer id){
        return ResultUtil.success(featuresService.getById(id),"查询");
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [user]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 18:28</P>
     * <p>@description: 按条件查询</p>
     */
    @PostMapping("/getOne")
    @ApiOperation(value = "按条件查询",notes = "按条件查询")
    public Result getOne(@RequestBody Features features){
        return ResultUtil.success(featuresService.getOne(new QueryWrapper<>(features,null)),"查询");
    }

    /***
     * <p>@author: James</p>
     * <p>@param: []</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 18:30</P>
     * <p>@description: 查询总数量</p>
     */
    @PostMapping("/getCount")
    @ApiOperation(value = "查询总记录数",notes = "查询总记录数")
    public Result getCount(){
        return ResultUtil.success(featuresService.count(null),"查询");
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [user, bindingResult]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 18:18</P>
     * <p>@description: 当个用户新增</p>
     */
    @PostMapping("/getSave")
    @ApiOperation(value = "新增",notes = "用户单个新增")
    public Result getSave(@Valid @RequestBody Features features, BindingResult bindingResult){
        if(featuresService.save(features)){
            return ResultUtil.success(features,"新增");
        }
        return ResultUtil.error("新增");
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [user]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 15:05</P>
     * <p>@description: 修改单个用户信息</p>
     */
    @PostMapping("/getUpdate")
    @ApiOperation(value = "修改",notes = "用户单个修改")
    public Result getUpdate(Features features){
        if(featuresService.updateById(features)){
            return ResultUtil.success(features,"修改");
        }
        return ResultUtil.error("修改");
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [id]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 17:01</P>
     * <p>@description: 删除</p>
     */
    @PostMapping("/getDelete/{id}")
    @ApiOperation(value = "删除",notes = "用户单个删除")
    public Result getDelete(@PathVariable Long id){
        if(featuresService.removeById(id)){
            return ResultUtil.success(id,"删除");
        }
        return ResultUtil.error("删除");
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [id]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 17:01</P>
     * <p>@description: 批量删除</p>
     */
    @PostMapping("/getDeleteIdList")
    @ApiOperation(value = "批量删除",notes = "根据用户id批量删除")
    public Result getDeleteIdList(@RequestBody List<Integer> ids){
        if(featuresService.removeByIds(ids)){
            return ResultUtil.success(ids,"批量删除");
        }
        return ResultUtil.error("批量删除");
    }


    /***
     * <p>@author: James</p>
     * <p>@param: [id]</P>
     * <p>@return: com.runrunfast.currency.entity.Result<com.runrunfast.currency.entity.User></P>
     * <p>@date: 2018/11/9 17:01</P>
     * <p>@description: 按条件删除</p>
     */
    @PostMapping("/getDeleteId")
    @ApiOperation(value = "按条件删除",notes = "按条件删除")
    public Result getDeleteId(@RequestBody Features features){
        if(featuresService.remove(new QueryWrapper <>(features,null))){
            return ResultUtil.success(features,"按条件删除");
        }
        return ResultUtil.error("按条件删除");
    }

}

