100
| %{$n=$_; 1..[Math]::Truncate([Math]::Sqrt($n))
| %{$x=$_; 2..[Math]::Truncate($n/$x)
| %{$x*$_}}}
| group{$_}
| where{$_.Count -eq 1}
| %{$_.Name}
