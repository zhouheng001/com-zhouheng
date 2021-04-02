/**
 * 项目业务全局资源
 * 该方法中的所有内容均可保留或删除
 */
(function () {
    /**
     * 全局Vue 对象属性
     * 这里设置的属性和方法会当做全局对象和方法被继承到具体页面中Vue对象中
     * 如果没有全局对象和方法请删除
     */
    $UU.global.vue_options = {
        data: function () {
            return {
                //全局 Vue data
                pickerOptions1: {
                    disabledDate: function (time) {
                        return time.getTime() > Date.now();
                    },
                    shortcuts: [{
                        text: '今天',
                        onClick: function (picker) {
                            picker.$emit('pick', new Date());
                        }
                    }, {
                        text: '昨天',
                        onClick: function (picker) {
                            var date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24);
                            picker.$emit('pick', date);
                        }
                    }, {
                        text: '一周前',
                        onClick: function (picker) {
                            var date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', date);
                        }
                    }]
                },
                pickerOptions2: {
                    shortcuts: [{
                        text: '最近一周',
                        onClick: function (picker) {
                            var end = new Date();
                            var start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近一个月',
                        onClick: function (picker) {
                            var end = new Date();
                            var start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近三个月',
                        onClick: function (picker) {
                            var end = new Date();
                            var start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },

                loading: false,
                btnDisabled: false,
                btnAddDisabled: false,
                btnDelDisabled: true,
                btnEditDisabled: true,
                listUrl: null,
                dataurl: null,
                searchGroup: {
                    active: 'active',
                    params: {}
                },
                dataGroup: {
                    active: 'active',
                    //表格选择
                    multiSel: [],
                    list: [],
                    //分页
                    pagination: {
                        index: 1,
                        size: 10,
                        total: 0,
                        pageSizes: [10, 30, 50, 100, 500, 1000]
                    }
                },
                dialogGroup: {
                    title: null,
                    show: false,
                    loagding: false,
                    btnSaveDisabled: true,
                    data: {}
                },
                uploadGroup: {
                    show: false,
                    loading: false,
                    title: "",
                    data: {type: ""},
                    action: this.upload,
                    err_show: false,
                    err_msg: null,
                    succ_show: false
                }
            };
        },
        created: function () {
        },
        mounted: function () {
        },
        methods: {
            //全局 Vue method
            //初始化
            init: function () {
            },
            disableListButton: function () {
                this.btnDisabled = true;
            },
            enableListButton: function () {
                this.btnDisabled = false;
            },
            //表格选择事件
            onDataSelectChange: function (val) {
                this.dataGroup.multiSel = val;
                this.btnDelDisabled = (function () {
                    return val.length <= 0;
                })();
                this.btnEditDisabled = (function () {
                    return val.length !== 1;
                })();
            },
            getSel: function () {
                return this.dataGroup.multiSel;
            },
            getSelKey: function () {
                var codes = [];
                for (var i = 0; i < this.dataGroup.multiSel.length; i++) {
                    codes.push(this.dataGroup.multiSel[i][this.dataKey]);
                }
                return codes;
            },
            onCurrentPageChange: function (index) {
                this.dataGroup.pagination.index = index;
                this.search();
            },
            onPageSizeChange: function (size) {
                this.dataGroup.pagination.size = size;
                this.search();
            },
            saveDialogClear: function () {
                this.dialogGroup = $UF.extend({}, this.$options.data().dialogGroup);
            },
            saveDialogClose: function () {
                var __this = this;
                this.$refs.saveDialog.beforeClose(function () {
                    __this.dialogGroup.show = false;
                });
            },
            onSaveDialogBeforeClose: function (done) {
                if (!this.dialogGroup.show) {
                    return;
                }

                this.saveDialogClear();
                if ($UF.isFunction(done)) {
                    done.call(this);
                }
            },
            //搜索方法
            search: function () {
                //请求参数
                var req = {
                    pageNo: this.dataGroup.pagination.index,
                    pageSize: this.dataGroup.pagination.size,
                    param: this.searchGroup.params
                };

                $UU.http.post(this.listUrl + "?r=" + Math.random() + "", req, function (res) {

                    if (!res.body.success) {
                        __this.$message.error('错误信息：' + res.body.msg + '');
                        return;
                    }

                    //查询成功
                    this.dataGroup.list = res.body.data.results;
                    this.dataGroup.pagination.total = res.body.data.totalCount;
                }, {
                    requestBody: true,
                    loading: false,
                    context: this,
                    before: function () {
                        this.loading = true;
                        this.disableListButton();
                    },
                    after: function () {
                        this.loading = false;
                        this.enableListButton();
                    }
                });
            },
            //搜索事件
            onSearch: function () {
                this.dataGroup.pagination.index = 1;
                this.search();
            },

            onAdd: function () {
                this.dialogGroup.title = "新增";
                this.dialogGroup.show = true;
                this.dialogGroup.btnSaveDisabled = false;
                // this.dialogGroup.data = {};
                this.dialogGroup.data = $UF.extend({}, this.$options.data().dialogGroup.data);
            },

            onEdit: function () {
                var req = {};
                req[this.dataKey] = this.getSelKey()[0];

                $UU.http.post(this.dataUrl + "?r=" + Math.random() + "", req, function (res) {
                    this.dialogGroup.title = "修改";
                    this.dialogGroup.show = true;
                    this.dialogGroup.btnSaveDisabled = false;
                    this.dialogGroup.data = res.body.data;
                }, {
                    requestBody: false,
                    loading: false,
                    context: this,
                    before: function () {
                        this.dialogGroup.loading = true;
                        this.disableListButton();
                    },
                    after: function () {
                        this.dialogGroup.loading = false;
                        this.enableListButton();
                    }
                });
            },

            onDelete: function () {
                this.$confirm("确认删除吗？").then(function () {
                    var req = this.getSelKey();

                    $UU.http.post(this.deleteUrl + "?r=" + Math.random() + "", req, function (res) {
                        if (!res.body.success) {
                            this.$message.error("删除失败：" + res.body.msg + "");
                            return;
                        }

                        this.$message.success('删除成功');
                        this.search();
                    }, {
                        requestBody: true,
                        loading: false,
                        context: this,
                        before: function () {
                            this.dialogGroup.loading = true;
                            this.disableListButton();
                        },
                        after: function () {
                            this.dialogGroup.loading = false;
                            this.enableListButton();
                        }
                    });
                }.bind(this)).catch(function () {
                    return;
                });
            },

            onSaveDialogClose: function () {
                this.saveDialogClose();
            },

            //保存窗口
            onSaveDialogSave: function () {
                var result = this.$ui_validate.validate("saveGroup");
                if (!result) {
                    this.$message.error("数据校验失败");
                    return false;
                }

                var req = this.dialogGroup.data;

                $UU.http.post(this.saveUrl + "?r=" + Math.random() + "", req, function (res) {

                    if (!res.body.success) {
                        this.$message.error("保存失败：" + res.body.msg + "");
                        return;
                    }

                    this.$message.success("保存成功");
                    this.search();
                    this.saveDialogClose();
                }, {
                    requestBody: true,
                    loading: false,
                    context: this,
                    before: function () {
                        this.dialogGroup.loading = true;
                        this.disableListButton();
                    },
                    after: function () {
                        this.dialogGroup.loading = false;
                        this.enableListButton();
                    }
                });
            },

            //导入Excel事件
            onImportExcel: function (type) {
                var __this = this;
                var a = {
                    t1: function () {
                        __this.uploadGroup.title = "导入";
                        __this.uploadGroup.data.type = "data";
                    }
                };
                if (type in a) {
                    a[type]();
                }
                this.uploadGroup.show = true;
            },
            onImportDialogClose: function () {
                this.uploadGroup.err_msg = null;
                this.uploadGroup.err_show = false;
                this.uploadGroup.succ_show = false;
                this.$refs.upload.clearFiles();
            },
            onImportSuccess: function (response) {
                if (response.code !== 0) {
                    this.uploadGroup.succ_show = false;
                    this.uploadGroup.err_show = true;
                    this.uploadGroup.err_msg = response.msg;
                } else {
                    this.uploadGroup.err_show = false;
                    this.uploadGroup.succ_show = true;
                    this.search();
                }
            },
            onImportError: function () {
                this.uploadGroup.err_show = true;
                this.uploadGroup.err_msg = "发生异常";
            }
        }
    };

    //公共数据对象

    /**
     * 设定公共枚举映射路径
     * 如果不设置，则默认值为 "/resource/enums/list";
     */
    $UD.global.resource.ENUMS_URL = "/resource/enums/list";

    /**
     * 读取 abcType
     */
    $UD.addRemoteResource("abcType", "/resource/abcClass/list", function (getJson) {
        return {
            list: function () {
                return getJson();
            }
        }
    });

    /**
     * 读取 仓库操作库
     */
    $UD.addRemoteResource("warehouse", "/resource/warehouse/list", function (getJson) {

        return {
            /**
             * 获取单个仓库
             * @param code 仓库编号
             * @returns {*}
             */
            get: function (code) {
                code = code || null;
                if (!code) {
                    return {};
                }
                var l = $UF.where(getJson(), "( el, i, res, param ) => el.warehouseCode == param", code);
                if ($UF.isArray(l) && l.length > 0) {
                    return l[0];
                }
                return {};
            },

            /**
             * 获取仓库列表
             *
             * @param type 仓库类型，不传则查询所有仓库
             * @returns {*}
             */
            list: function (type) {
                type = type || null;
                if (!type) {
                    return getJson();
                }
                if ($UF.isArray(type)) {
                    return getJson().filter(function (item) {
                        return $UF.inArray(item.type, type);
                    });
                }
                return $UF.where(getJson(), "( el, i, res, param ) => el.type == param", type);
            },

            /**
             * 获取仓库列表
             *
             * @param type 排除的仓库类型
             * @returns {*}
             */
            exclude: function (type) {
                type = type || null;
                if (!type) {
                    return getJson();
                }
                return $UF.where(getJson(), "( el, i, res, param ) => el.type != param", type);
            },

            /**
             * 获取子仓库
             *
             * @param parentCode 父仓库编号
             * @param type 仓库类型，不传则查询所有仓库
             * @returns {*}
             */
            listChildren: function (parentCode, type) {
                parentCode = parentCode || null;
                type = type || null;
                if (!parentCode) {
                    return [];
                }

                return $UF.where(getJson(), "( el, i, res, param1, param2 ) => el.parentWarehouseCode == param1 " + (type ? "&& el.type == param2" : "") + "", parentCode, type);
            }
        }
    });

    /**
     * 生成随机数
     */
    $UD.addRemoteResource("idGenerator", "/resource/generator/id", function (getJson) {
        return {
            get: function (length) {
                return getJson({length: length});
            }
        }
    }, true);

    /**
     * 读取用户登录权限
     */
    $UD.addRemoteResource("permissions", "/resource/user/permissions", function (getJson) {
        return {
            list: function () {
                return getJson();
            },
            hasPermit: function (code) {
                var list = getJson();
                for (var i = 0; i < list.length; i++) {
                    if ($UF.validate.blank(code)) {
                        continue;
                    }
                    if (list[i] == code) {
                        return true;
                    }
                }
                return false;
            }
        }
    });

    /**
     * 读取门店省集合
     */
    $UD.addRemoteResource("manhourProvince", "/resource/manhour/province", function (getJson) {
        return {
            list: function () {
                return getJson();
            }
        }
    });

    /**
     * 读取门店市集合
     */
    $UD.addRemoteResource("manhourCity", "/resource/manhour/city", function (getJson) {
        return {
            list: function () {
                return getJson();
            }
        }
    });

    /**
     * 读取门店集合
     */
    $UD.addRemoteResource("manhourMendian", "/resource/manhour/mendian", function (getJson) {
        return {
            list: function () {
                return getJson();
            }
        }
    });

    /**
     * 读取钣喷集合
     */
    $UD.addRemoteResource("manhourBanpen", "/resource/manhour/banpen", function (getJson) {
        return {
            list: function () {
                return getJson();
            }
        }
    });

    /**
     * 读取采购单的所有目标仓库集合
     */
    $UD.addRemoteResource("purchaseOrderWarehouse", "/resource/purchaseorder/warehouse", function (getJson) {
        return {
            list: function () {
                var json = getJson();
                for (var i = 0; i < json.length; i++) {
                    json[i].text = $UD.warehouse.get(json[i].value).name;
                }
                return json;
            }
        }
    });

    /**
     * 读取采购组集合
     */
    $UD.addRemoteResource("purchaseGroup", "/resource/purchaseGroup/purchaseGroup", function (getJson) {
        return {
            list: function () {
                return getJson();
            }
        }
    });

    $UD.bomReplacesType = {
        t1: {msg1: 'A <-> B', msg2: '新旧零件可以互相替换'},
        t2: {msg1: 'A <- B', msg2: '新零件可以替换旧零件'},
        t3: {msg1: 'A -> B', msg2: '旧零件可以替换新零件'},
        t4: {msg1: 'A <-> B+C', msg2: '旧零件可以与新零件组合互相替换'},
        t5: {msg1: 'A <- B+C', msg2: '新零件组合可以替换旧零件'},
        t6: {msg1: 'A -> B+C', msg2: '旧零件可以替换新零件组合'},
        t7: {msg1: 'A+B <-> C+D', msg2: '新旧组合零件可以互相替换'},
        t8: {msg1: 'A+B <- C+D', msg2: '新零件组合可以替换旧零件组合'},
        t9: {msg1: 'A+B -> C+D', msg2: '旧零件组合可以替换新零件组合'},
        t10: {msg1: 'A ≠ B', msg2: '新旧零件不可以互相替换'}
    };

    // /**
    //  * 维修项操作库
    //  */
    // $UD.addRemoteResource("repair", "/resource/workrepair/list", function (getJson) {
    //
    //     var _json = getJson();
    //
    //     if (!_json) {
    //         return {};
    //     }
    //     for (var i = 0; i < _json.length; i++) {
    //         _json[i]["value"] = _json[i].repairName;
    //     }
    //
    //     return {
    //         /**
    //          * 获取单个维修项
    //          *
    //          * @param code 维修项编号
    //          * @returns {*}
    //          */
    //         get: function (code) {
    //             code = code || null;
    //             if (!code) {
    //                 return {};
    //             }
    //             var l = $UF.where(_json, "( el, i, res, param ) => el.repairCode == param", code);
    //             if ($UF.isArray(l) && l.length > 0) {
    //                 return l[0];
    //             }
    //             return {};
    //         },
    //
    //         /**
    //          * 获取维修项列表
    //          *
    //          * @returns {*}
    //          */
    //         list: function () {
    //             return _json;
    //         }
    //     }
    // });

    // /**
    //  * 零件操作库
    //  */
    // $UD.addRemoteResource("material", "/resource/material/list", function (getJson) {
    //
    //     var _json = getJson();
    //
    //     if (!_json) {
    //         return {};
    //     }
    //     for (var i = 0; i < _json.length; i++) {
    //         _json[i]["value"] = _json[i].materialCode + ":" + _json[i].materialName;
    //     }
    //
    //     return {
    //         /**
    //          * 获取单个零件
    //          * @param code 零件编号
    //          * @returns {*}
    //          */
    //         get: function (code) {
    //             code = code || null;
    //             if (!code) {
    //                 return {};
    //             }
    //             var l = $UF.where(_json, "( el, i, res, param ) => el.materialCode == param", code);
    //             if ($UF.isArray(l) && l.length > 0) {
    //                 return l[0];
    //             }
    //             return {};
    //         },
    //
    //         /**
    //          * 获取所有零件列表
    //          *
    //          * @returns {*}
    //          */
    //         list: function () {
    //             return _json;
    //         }
    //     }
    // });
})();