/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leenjewel.cocos2d.spritesheeter.application.logic;

/**
 *
 * @author leenjewel
 */
public enum SortOn {
    SortOnCustom{
        @Override
        public String toString(){
            return "Custom";
        }
    },
    SortOnWidth{
        @Override
        public String toString(){
            return "Width";
        }
    },
    SortOnHeight{
        @Override
        public String toString(){
            return "Height";
        }
    };
    @Override
    abstract public String toString();
    
    public static SortOn getByString(String s){
        if ("Width".equals(s)){
            return SortOnWidth;
        } else if ("Height".equals(s)){
            return SortOnHeight;
        } else if ("Custom".equals(s)) {
            return SortOnCustom;
        } else {
            return null;
        }
    };
}
