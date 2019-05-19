package com.zhouheng.commybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@TableName(value = "t_user_0000")
@Data
public class TUser0000 extends Model<TUser0000> {

  private long id;
  private String userNum;
  private String userName;
  private String password;
  private long age;

}
