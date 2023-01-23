# java version manager
## jabba

default 不生效的问题
```
//C:\Users\zhj\.jabba\jabba.ps1 追加
if (Test-Path "$env:USERPROFILE\.jabba\default.alias") {
    jabba use default
    echo "now using Java: $(jabba current)"
}
```
如果还想切换版本的功能 追加
```
function jdk {
    param($version)
    echo $version > ~/.jabbarc
    jabba use default
    echo "now using Java: $(jabba current)"
    $envRegKey = [Microsoft.Win32.Registry]::LocalMachine.OpenSubKey('SYSTEM\CurrentControlSet\Control\Session Manager\Environment', $true)
    $envPath=$envRegKey.GetValue('Path', $null, "DoNotExpandEnvironmentNames").replace('%JAVA_HOME%\bin;', '')
    [Environment]::SetEnvironmentVariable('JAVA_HOME', "$(jabba which $(jabba current))", 'Machine')
    [Environment]::SetEnvironmentVariable('PATH', "%JAVA_HOME%\bin;$envPath", 'Machine')
}
```
