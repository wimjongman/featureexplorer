package com.remainsoftware.featureexplorer.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.osgi.framework.Bundle;

public class FeatureExplorerAdapterFactory implements IAdapterFactory {

	private static FeatureExplorerAdapterFactory instance;

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		System.out.println(adaptableObject.getClass().getSimpleName());
		System.out.println(adapterType);
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { Bundle.class, IBundleGroup.class,
				IBundleGroupProvider.class };
	}

	public static IAdapterFactory getInstance() {
		if (instance == null)
			instance = new FeatureExplorerAdapterFactory();
		return instance;
	}
}
