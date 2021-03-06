package com.dg.apps.th.engine.search.name;

import java.io.File;

import com.dg.apps.th.engine.search.SearchConfiguration;
import com.dg.apps.th.engine.util.FileUtility;
import com.dg.apps.th.engine.util.StringUtility;
import org.apache.log4j.Logger;

public class CaseInsensitiveFileNameSearcher implements IFileNameSearcher
{
	private Logger logger = Logger.getLogger(CaseInsensitiveFileNameSearcher.class);
	private static CaseInsensitiveFileNameSearcher instance = null;
	
	private CaseInsensitiveFileNameSearcher()
	{
		logger.debug("created instance.");
	}
	
	public static CaseInsensitiveFileNameSearcher getInstance()
	{
		if(instance == null)
			instance = new CaseInsensitiveFileNameSearcher();
		return instance;
	}
	
	public FileNameSearchResult searchFileName(File file, SearchConfiguration config)
	{
		String fileName = StringUtility.toLowerCase(FileUtility.getShortFileName(file));
		String searchTarget = StringUtility.toLowerCase(config.getSearchString());
		
		if(fileName.contains(searchTarget))
			return FileNameSearchResult.Found;
		return FileNameSearchResult.NotFound;
	}
}
