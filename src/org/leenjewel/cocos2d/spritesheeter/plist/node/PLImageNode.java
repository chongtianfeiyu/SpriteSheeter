/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leenjewel.cocos2d.spritesheeter.plist.node;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.leenjewel.cocos2d.spritesheeter.plist.PLObject;
import org.leenjewel.cocos2d.spritesheeter.plist.objects.PLDictionary;

/**
 *
 * @author leenjewel
 */
public class PLImageNode extends PLNode<BufferedImage> {
    private BufferedImage _imageBuffer;
    private int _offsetX = 0, _offsetY = 0;

    public PLImageNode(File imageFile) throws IOException{
        _data = ImageIO.read(imageFile);
        _name = imageFile.getName();
    }

    public PLImageNode(BufferedImage imageBuffer, String name){
        _data = imageBuffer;
        _name = name;
    }

    public int getOffsetX(){
        return _offsetX;
    }

    public void setOffsetX(int offsetX){
        _offsetX = offsetX;
    }

    public int getOffsetY(){
        return _offsetY;
    }

    public void setOffsetY(int offsetY){
        _offsetY = offsetY;
    }

    @Override
    public int getWidth(){
        return _data.getWidth(null);
    }

    @Override
    public int getHeight(){
        return _data.getHeight(null);
    }

    @Override
    public int getScaleWidth() {
        return (int)(getWidth()*getScale());
    }

    @Override
    public int getScaleHeight() {
        return (int)(getHeight()*getScale());
    }

    public String printOffset(){
        return "{" + String.valueOf(getOffsetX()) + ", " + String.valueOf(getOffsetY()) + "}";
    }

    public String printSourceSize(){
        return "{" + String.valueOf(getWidth()) + ", " + String.valueOf(getHeight()) + "}";
    }

    public String printFrame(){
        return "{{" + String.valueOf(getX()) + ", " + String.valueOf(getY()) + "}, {" + String.valueOf(getWidth()) + ", " + String.valueOf(getHeight()) + "}}";
    }

    public String printSourceColorRect(){
        return printFrame();
    }

    @Override
    public PLObject buildPLObject(){
        PLDictionary node = new PLDictionary();
        node.put("frame", printFrame());
        node.put("offset", printOffset());
        node.put("sourceColorRect", printSourceColorRect());
        node.put("sourceSize", printSourceSize());
        return node;
    }
}
