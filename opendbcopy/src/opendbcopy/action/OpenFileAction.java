/*
 * Copyright (C) 2003 Anthony Smith
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * ----------------------------------------------------------------------------
 * TITLE $Id$
 * ---------------------------------------------------------------------------
 * $Log$
 * --------------------------------------------------------------------------*/
package opendbcopy.action;

import opendbcopy.config.XMLTags;

import opendbcopy.controller.MainController;

import opendbcopy.gui.DialogFile;
import opendbcopy.gui.FrameMain;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.jdom.Element;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


/**
 * class description
 *
 * @author Anthony Smith
 * @version $Revision$
 */
public class OpenFileAction extends AbstractAction {
    private static Logger  logger = Logger.getLogger(OpenFileAction.class.getName());
    private MainController controller;
    private FrameMain      frame;
    private Element        operation;

    /**
     * Creates a new OpenFileAction object.
     *
     * @param command DOCUMENT ME!
     * @param fileType DOCUMENT ME!
     * @param frame DOCUMENT ME!
     * @param controller DOCUMENT ME!
     */
    public OpenFileAction(String         command,
                          String         fileType,
                          FrameMain      frame,
                          MainController controller) {
        putValue(AbstractAction.NAME, command);

        this.operation = new Element(XMLTags.OPERATION);
        this.operation.setAttribute(XMLTags.NAME, command);
        this.operation.setAttribute(XMLTags.FILE_TYPE, fileType);

        this.controller     = controller;
        this.frame          = frame;
    }

    /**
     * DOCUMENT ME!
     *
     * @param evt DOCUMENT ME!
     */
    public void actionPerformed(ActionEvent evt) {
        DialogFile dialogFile = new DialogFile(this.frame, this.operation.getAttributeValue(XMLTags.NAME), this.operation.getAttributeValue(XMLTags.FILE_TYPE));

        operation.setAttribute(XMLTags.FILE, dialogFile.openDialog());

        if (operation.getAttributeValue(XMLTags.FILE).length() > 0) {
            try {
                controller.execute(operation);
            } catch (Exception e) {
                logger.error(e.toString());
                frame.setStatusBar(e.toString(), Level.ERROR);
            }
        }

        dialogFile = null;
    }
}
