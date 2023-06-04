#include "ru_obvilion_progressbar_ProgressBar.h"
#include <Shobjidl.h>
#include <windows.h>

char* titleHWND;

ITaskbarList3* getTaskBar() {
	HRESULT hr;
	ITaskbarList3* taskBar = NULL;
	CoInitialize(NULL);

	hr = CoCreateInstance(CLSID_TaskbarList, NULL, CLSCTX_SERVER,
		IID_ITaskbarList3, (LPVOID*)&taskBar);

	if (SUCCEEDED(hr)) {
		taskBar->HrInit();
	}

	return taskBar;
}

HWND getWindowHandle(char* title) {
	HWND hwnd = NULL;
	const int len = strlen(title) + 1;
	const int wlen = MultiByteToWideChar(CP_UTF8, 0, title, len, NULL, 0);
	LPWSTR wtitle = new WCHAR[wlen];
	MultiByteToWideChar(CP_UTF8, 0, title, len, wtitle, wlen);
	hwnd = FindWindowW(NULL, wtitle);
	delete[] wtitle;
	return hwnd;
}

char* jstringToChar(JNIEnv* env, jstring str) {
	const char* temp = env->GetStringUTFChars(str, NULL);
	size_t len = strlen(temp) + 1;
	char* result = new char[len];
	strcpy_s(result, len, temp);
	env->ReleaseStringUTFChars(str, temp);
	return result;
}

JNIEXPORT void JNICALL Java_ru_obvilion_progressbar_ProgressBar_setProgressState(JNIEnv *env, jclass cls, jint state) {

	ITaskbarList3* taskBar = getTaskBar();

	long oo = state;

	if (taskBar != NULL) {
		HRESULT hr = taskBar->SetProgressState(getWindowHandle(titleHWND), (TBPFLAG)oo);
		taskBar->Release();
	}
}

JNIEXPORT void JNICALL Java_ru_obvilion_progressbar_ProgressBar_setProgressValue(JNIEnv *env, jclass cls, jint value) {
	ITaskbarList3* taskBar = getTaskBar();

	if (taskBar != NULL) {
		HRESULT hr = taskBar->SetProgressValue(getWindowHandle(titleHWND), value, 100);
		taskBar->Release();
	}
}

JNIEXPORT void JNICALL Java_ru_obvilion_progressbar_ProgressBar_setWindowName(JNIEnv* env, jclass cls, jstring name) {
	titleHWND = jstringToChar(env, name);
}
