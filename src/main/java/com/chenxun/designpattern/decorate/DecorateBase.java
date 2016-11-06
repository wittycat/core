package com.chenxun.designpattern.decorate;


/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:38:38 
 * Theme:
 * reference:
 * descript:
 */
public class DecorateBase implements Standard{
    
	protected Standard standard;
	
	protected void setStandard(Standard st) {
		this.standard = st;
	}

	@Override
	public void say() {
		if(standard!=null){
			standard.say();
		}
	}
}
